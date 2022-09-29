package com.idiot.dip.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.idiot.dip.R
import com.idiot.dip.databinding.FragmentInterestBinding

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
        viewPager.adapter = InterestPagerAdapter(this)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = getTabTitle(position)
        }.attach()

        subscribeUi(binding)

        return binding.root
    }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            RECENT_ESTATE_PAGE_INDEX -> getString(R.string.recent_estate)
            DIP_ESTATE_PAGE_INDEX -> getString(R.string.dip_estate)
            INQUIRY_ESTATE_PAGE_INDEX -> getString(R.string.inquiry_estate)
            else -> null
        }
    }

    private fun subscribeUi(binding: FragmentInterestBinding) {
        binding.toolbarInterest.appBar.elevation = 0f
        binding.toolbarInterest.appBar.stateListAnimator = null
    }
}