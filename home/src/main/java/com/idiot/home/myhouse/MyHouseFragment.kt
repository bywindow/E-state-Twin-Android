package com.idiot.home.myhouse

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.idiot.home.R
import com.idiot.home.databinding.FragmentMyHouseBinding
import com.idiot.home.myhouse.adapters.MyHousePagerAdapter
import com.idiot.home.myhouse.adapters.OWNER_MODE_PAGE_INDEX
import com.idiot.home.myhouse.adapters.TENANT_MODE_PAGE_INDEX

class MyHouseFragment : Fragment() {

    private lateinit var binding: FragmentMyHouseBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_my_house, container,false
        )
        viewPager = binding.viewPager
        viewPager.adapter = MyHousePagerAdapter(this)

        tabLayout = binding.tabMenu
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = getTabTitle(position)
        }.attach()

        subscribeUi(binding)

        return binding.root
    }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            TENANT_MODE_PAGE_INDEX -> getString(R.string.tenant_mode)
            OWNER_MODE_PAGE_INDEX -> getString(R.string.owner_mode)
            else -> null
        }
    }

    private fun subscribeUi(binding: FragmentMyHouseBinding) {
        binding.toolbarMyhouse.appBar.elevation = 0f
        binding.toolbarMyhouse.appBar.stateListAnimator = null
    }
}