package com.idiot.common_ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.idiot.common_ui.databinding.FragmentNewRegisterRequestBinding

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