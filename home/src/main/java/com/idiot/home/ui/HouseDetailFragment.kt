package com.idiot.home.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.idiot.data.repository.samples.imageUrlSample
import com.idiot.home.databinding.FragmentHouseDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

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
    binding.lifecycleOwner = viewLifecycleOwner
    binding.vm = viewModel

    initAdapter()

    fetchBrokerProfile()
    navigateButtonClicked()

    return binding.root
  }

  private fun initAdapter() {
    viewLifecycleOwner.lifecycleScope.launch {
      viewModel.fetchEstateDetail(args.houseId).collect {
        binding.glideSlideViewPager.adapter = HouseImageSliderAdapter(viewModel.estateImageList.value)
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
//      val directions = HouseDetailFragmentDirections.actionHouseDetailFragmentToFloorPlanFragment(viewModel.detailEstate.value!!.model)
//      findNavController().navigate(directions)
//      val data = "https://arvr.google.com/scene-viewer/1.0?file=${viewModel.detailEstate.value!!.model}"
      val data = "https://arvr.google.com/scene-viewer/1.0?file=https://raw.githubusercontent.com/KhronosGroup/glTF-Sample-Models/master/2.0/Avocado/glTF/Avocado.gltf"
      val intent = Intent(Intent.ACTION_VIEW)
      intent.data = Uri.parse(data).buildUpon().appendQueryParameter("mode", "3d_only").build()
      startActivity(intent)
    }
    binding.backButton.setOnClickListener {
      findNavController().navigateUp()
    }
  }
}