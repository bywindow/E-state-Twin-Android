package com.idiot.common_ui.detail

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.idiot.common_ui.R
import com.idiot.common_ui.detail.adapters.HouseImageSliderAdapter
import com.idiot.common_ui.detail.adapters.HouseOptionListAdapter
import com.idiot.common_ui.databinding.FragmentHouseDetailBinding
import com.idiot.data.repository.samples.OptionSample
import com.idiot.e_state_twin_android.core.data.assets.imageUrlSample
import com.idiot.threeviewer.ViewerActivity
import java.lang.Exception

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

        binding.detailOptionList.adapter = HouseOptionListAdapter(OptionSample())

        binding.threeDimenButton.setOnClickListener {
            try {
                startActivity(
                    Intent(context, ViewerActivity::class.java)
                        .putExtra("title", getString(R.string.viewer_3d_button_text)))
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        test(binding)

        return binding.root
    }

    private fun test(binding: FragmentHouseDetailBinding) {
        Glide.with(this)
            .load("https://cdn.pixabay.com/photo/2016/11/23/00/44/arches-1851520_960_720.jpg")
            .into(binding.brokerProfileImageView)
    }
}