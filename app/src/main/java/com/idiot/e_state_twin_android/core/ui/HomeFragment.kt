package com.idiot.e_state_twin_android.core.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.idiot.e_state_twin_android.R
import com.idiot.e_state_twin_android.core.viewmodels.UserRecommendViewModel
import com.idiot.e_state_twin_android.databinding.FragmentHomeBinding

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

        viewModel = ViewModelProvider(this)[UserRecommendViewModel::class.java]

        return binding.root
    }
}