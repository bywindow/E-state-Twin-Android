package com.idiot.home.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.idiot.data.repository.samples.imageUrlSample
import com.idiot.home.databinding.FragmentHouseDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class HouseDetailFragment : Fragment() {

  private lateinit var binding: FragmentHouseDetailBinding
  private val viewModel: HouseDetailViewModel by viewModels()
  private val args: HouseDetailFragmentArgs by navArgs()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = FragmentHouseDetailBinding.inflate(inflater, container, false)
    binding.lifecycleOwner = this
    binding.vm = viewModel

    initAdapter()

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    fetchBrokerProfile()
    navigateButtonClicked()
    dipButtonClicked()
    inquiryButtonClicked()
    runProcessButtonClicked()

  }

  private fun initAdapter() {
    viewLifecycleOwner.lifecycleScope.launch {
      viewModel.fetchEstateDetail(args.houseId).collect {
        binding.glideSlideViewPager.adapter =
          HouseImageSliderAdapter(viewModel.estateImageList.value)
      }
    }
    binding.optionAdapter = HouseOptionListAdapter()
  }

  private fun fetchBrokerProfile() {
    Glide.with(this)
      .load("https://cdn.pixabay.com/photo/2016/11/23/00/44/arches-1851520_960_720.jpg")
      .into(binding.brokerProfileImageView)
  }

  private fun navigateButtonClicked() {
    binding.threeDimenButton.setOnClickListener {
      val data =
        "https://arvr.google.com/scene-viewer/1.0?file=https://idiot-model-bucket.s3.ap-northeast-2.amazonaws.com/Model/12/anam.glb"
      val intent = Intent(Intent.ACTION_VIEW)
      intent.data = Uri.parse(data).buildUpon().appendQueryParameter("mode", "3d_only").build()
      startActivity(intent)
    }
    binding.ARCameraButton.setOnClickListener {
      if (!viewModel.detailEstate.value!!.inquiry) {
        Toast.makeText(requireContext(), "방문 예약 후 이용하실 수 있습니다.", Toast.LENGTH_SHORT).show()
        return@setOnClickListener
      }
      val data = viewModel.assetList.value
      val intent = Intent(context, ResolveAnchorActivity::class.java).apply {
        putExtra("data", ArrayList(data))
      }
      startActivity(intent)
    }
    binding.backButton.setOnClickListener {
      findNavController().navigateUp()
    }
  }

  private fun dipButtonClicked() {
    binding.houseLikeButton.setOnClickListener {
      viewLifecycleOwner.lifecycleScope.launch {
        viewModel.requestDipEstate(args.houseId).collect() {
          Timber.d("DIP BUTTON")
        }
      }
    }
  }

  private fun inquiryButtonClicked() {
    binding.visitReservation.setOnClickListener {
      if (viewModel.detailEstate.value!!.inquiry) {
        Toast.makeText(requireContext(), "이미 방문예약을 요청하였습니다.", Toast.LENGTH_SHORT).show()
        return@setOnClickListener
      }
      viewLifecycleOwner.lifecycleScope.launch {
        viewModel.requestInquiryEstate().collect() {
          Timber.d("INQUIRY BUTTON")
        }
      }
    }
  }

  private fun runProcessButtonClicked() {
    binding.runProcess.setOnClickListener {
      viewLifecycleOwner.lifecycleScope.launch {
        viewModel.requestContractEstate().collect() {
          when (it) {
            is EstateDetailEvent.ContractEstateSuccess -> {
              Timber.d("CONTRACT : ${it.estateId}")
              Toast.makeText(requireContext(), "계약을 요청했습니다. 진행중인 계약으로 이동합니다.", Toast.LENGTH_SHORT).show()
            }
            is EstateDetailEvent.ContractEstateFailed -> {
              Toast.makeText(requireContext(), "이미 계약 진행중입니다.", Toast.LENGTH_SHORT).show()
            }
            else -> { }
          }
        }
      }
    }
  }
}