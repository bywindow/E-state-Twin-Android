package com.idiot.e_state_twin_android.core.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.idiot.e_state_twin_android.R
import com.idiot.e_state_twin_android.databinding.FragmentNewRegisterRequestBinding

class NewRegisterRequestFragment : Fragment() {

    private lateinit var binding: FragmentNewRegisterRequestBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentNewRegisterRequestBinding.inflate(inflater, container, false)

        return binding.root
    }
}