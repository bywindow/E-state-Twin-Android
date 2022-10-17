package com.idiot.more.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.idiot.more.R
import com.idiot.more.databinding.FragmentRegisterBinding
import com.idiot.more.ui.adapter.NEW_REGISTER_PAGE_INDEX
import com.idiot.more.ui.adapter.PAUSE_REGISTER_PAGE_INDEX
import com.idiot.more.ui.adapter.RegisterPagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_register, container, false
        )
        viewPager = binding.viewPager
        viewPager.adapter = RegisterPagerAdapter(this)

        tabLayout = binding.tabMenu
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = getTabTitle(position)
        }.attach()

        subscribeUi(binding)

        return binding.root
    }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            NEW_REGISTER_PAGE_INDEX -> getString(R.string.new_request_title)
            PAUSE_REGISTER_PAGE_INDEX -> getString(R.string.pause_request_title)
            else -> null
        }
    }

    private fun subscribeUi(binding: FragmentRegisterBinding) {
        binding.toolbarRegister.appBar.elevation = 0f
        binding.toolbarRegister.appBar.stateListAnimator = null
    }

}