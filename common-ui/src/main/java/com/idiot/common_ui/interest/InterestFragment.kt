package com.idiot.common_ui.interest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.idiot.common_ui.R
import com.idiot.common_ui.databinding.FragmentInterestBinding

class InterestFragment : Fragment() {

    private lateinit var binding: FragmentInterestBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_interest, container,false
        )
        viewPager = binding.viewPager
        tabLayout = binding.tabMenu

        subscribeUi(binding)

        return binding.root
    }

    private fun subscribeUi(binding: FragmentInterestBinding) {
        binding.toolbarInterest.appBar.elevation = 0f
        binding.toolbarInterest.appBar.stateListAnimator = null
    }
}