package com.idiot.common_ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.idiot.common.home.viewmodels.UserRecommendViewModel
import com.idiot.common_ui.R
import com.idiot.common_ui.databinding.FragmentHomeBinding
import com.idiot.common_ui.home.adapters.UserRecommendAdapter
import com.idiot.e_state_twin_android.core.data.assets.RecommendedHousesSample

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: UserRecommendViewModel

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