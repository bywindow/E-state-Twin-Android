package com.idiot.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.idiot.e_state_twin_android.core.data.assets.RecommendedHousesSample
import com.idiot.home.R
import com.idiot.home.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, container,false
        )
        binding.homeRecommendList.adapter = UserRecommendAdapter(RecommendedHousesSample())
        binding.homeRecommendList.itemAnimator = null
        return binding.root
    }
}