package com.idiot.more.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.idiot.more.databinding.FragmentNewRegisterRequestBinding
import com.idiot.data.repository.samples.RegisterSample
import com.idiot.more.ui.adapter.RegisterNewInquiryAdapter

class NewRegisterRequestFragment : Fragment() {

    private lateinit var binding: FragmentNewRegisterRequestBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentNewRegisterRequestBinding.inflate(inflater, container, false)
        binding.registerRequestList.adapter = RegisterNewInquiryAdapter(RegisterSample())

        return binding.root
    }
}