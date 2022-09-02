package com.idiot.common_ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.idiot.common_ui.R
import com.idiot.common_ui.databinding.FragmentRegisterForBrokerBinding
import com.idiot.common_ui.register.adapters.NEW_REGISTER_PAGE_INDEX
import com.idiot.common_ui.register.adapters.PAUSE_REGISTER_PAGE_INDEX
import com.idiot.common_ui.register.adapters.RegisterPagerAdapter

class RegisterForBrokerFragment : Fragment() {

    private lateinit var binding: FragmentRegisterForBrokerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = FragmentRegisterForBrokerBinding.inflate(inflater, container, false)

        return binding.root
    }

}