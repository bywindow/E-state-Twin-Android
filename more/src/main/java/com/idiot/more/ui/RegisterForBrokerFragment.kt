package com.idiot.more.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.idiot.more.databinding.FragmentRegisterForBrokerBinding

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