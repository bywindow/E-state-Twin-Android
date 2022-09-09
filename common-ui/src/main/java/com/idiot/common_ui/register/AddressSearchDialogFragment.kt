package com.idiot.common_ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.idiot.common_ui.R
import com.idiot.common_ui.databinding.FragmentAddressSearchDialogBinding

class AddressSearchDialogFragment : DialogFragment() {

    private lateinit var binding: FragmentAddressSearchDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_address_search_dialog, container, false
        )

        return binding.root
    }
}