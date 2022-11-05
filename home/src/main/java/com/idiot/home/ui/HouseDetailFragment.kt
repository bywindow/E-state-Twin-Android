package com.idiot.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.idiot.data.repository.samples.imageUrlSample
import com.idiot.home.databinding.FragmentHouseDetailBinding
import dagger.hilt.android.AndroidEntryPoint

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
    binding.vm = viewModel
    viewModel.fetchEstateDetail(args.houseId)

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    fetchBrokerProfile()
    binding.glideSlideViewPager.adapter = HouseImageSliderAdapter(viewModel.detailEstate.value!!.estatePhotos)
    binding.optionAdapter = HouseOptionListAdapter()
    navigateButtonClicked()
  }

  private fun fetchBrokerProfile() {
    Glide.with(this)
      .load("https://cdn.pixabay.com/photo/2016/11/23/00/44/arches-1851520_960_720.jpg")
      .into(binding.brokerProfileImageView)
  }

  private fun navigateButtonClicked() {
    binding.threeDimenButton.setOnClickListener {
      val directions = HouseDetailFragmentDirections.actionHouseDetailFragmentToFloorPlanFragment()
      findNavController().navigate(directions)
    }
  }
}