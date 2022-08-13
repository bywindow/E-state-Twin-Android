package com.idiot.e_state_twin_android.core.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.tabs.TabLayoutMediator
import com.idiot.e_state_twin_android.R
import com.idiot.e_state_twin_android.core.adapters.NEW_REGISTER_PAGE_INDEX
import com.idiot.e_state_twin_android.core.adapters.PAUSE_REGISTER_PAGE_INDEX
import com.idiot.e_state_twin_android.core.adapters.RegisterPagerAdapter
import com.idiot.e_state_twin_android.databinding.FragmentRegisterForBrokerBinding

class RegisterForBrokerFragment : Fragment() {

    private lateinit var binding: FragmentRegisterForBrokerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = FragmentRegisterForBrokerBinding.inflate(inflater, container, false)

        val viewPager = binding.viewPager
        val tabLayout = binding.tabMenu
        viewPager.adapter = RegisterPagerAdapter(this)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = getTabTitle(position)
        }.attach()

        return binding.root
    }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            NEW_REGISTER_PAGE_INDEX -> getString(R.string.new_request_title)
            PAUSE_REGISTER_PAGE_INDEX -> getString(R.string.pause_request_title)
            else -> null
        }
    }
}