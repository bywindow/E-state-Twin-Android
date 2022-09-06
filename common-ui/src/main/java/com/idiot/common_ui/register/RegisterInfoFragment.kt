package com.idiot.common_ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.google.android.material.appbar.MaterialToolbar
import com.idiot.common_ui.R
import com.idiot.common_ui.databinding.FragmentRegisterInfoBinding

class RegisterInfoFragment : Fragment() {

    private lateinit var binding: FragmentRegisterInfoBinding
    private lateinit var toolbar: MaterialToolbar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register_info, container, false)
        toolbar = binding.toolbarRegisterInfo.toolbar

        initNavigation()

        return binding.root
    }

    private fun initNavigation() {
        toolbar.setNavigationIcon(R.drawable.ic_navigate_up)
        toolbar.setNavigationOnClickListener {
            it.findNavController().navigateUp()
        }
    }

}