package com.idiot.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.idiot.data.repository.samples.imageUrlSample
import com.idiot.home.assets.optionSample
import com.idiot.home.databinding.FragmentHouseDetailBinding

class HouseDetailFragment : Fragment() {

  private lateinit var binding: FragmentHouseDetailBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = FragmentHouseDetailBinding.inflate(inflater, container, false)
    val imageSliderBinding = binding.glideSlideViewPager

    val images = imageUrlSample()
    imageSliderBinding.adapter = HouseImageSliderAdapter(images)

    binding.detailOptionList.adapter = HouseOptionListAdapter(optionSample())

    binding.threeDimenButton.setOnClickListener {
      val directions = HouseDetailFragmentDirections.actionHouseDetailFragmentToFloorPlanFragment()
      findNavController().navigate(directions)
    }

    test()

    return binding.root
  }

  private fun test() {
    Glide.with(this)
      .load("https://cdn.pixabay.com/photo/2016/11/23/00/44/arches-1851520_960_720.jpg")
      .into(binding.brokerProfileImageView)
  }
}