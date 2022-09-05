package com.idiot.common_ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.idiot.common_ui.R
import com.idiot.common_ui.databinding.FragmentRegisterInfoBinding

class RegisterInfoFragment : Fragment() {
    
    private lateinit var binding: FragmentRegisterInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register_info, container, false)
        return binding.root
    }

}