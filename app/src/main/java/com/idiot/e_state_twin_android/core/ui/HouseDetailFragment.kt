package com.idiot.e_state_twin_android.core.ui

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.idiot.e_state_twin_android.R
import com.idiot.e_state_twin_android.core.adapters.HouseImageSliderAdapter
import com.idiot.e_state_twin_android.core.data.assets.imageUrlSample
import com.idiot.e_state_twin_android.databinding.FragmentHouseDetailBinding
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

        imageSliderBinding.adapter = HouseImageSliderAdapter(imageUrlSample())

        binding.threeDimenButton.setOnClickListener {
            try {
                startActivity(
                    Intent(context, ViewerActivity::class.java)
                        .putExtra("title", getString(R.string.viewer_3d_button_text)))
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        return binding.root
    }

}