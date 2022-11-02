package com.idiot.more.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.idiot.data.repository.samples.RegisterSample
import com.idiot.more.databinding.FragmentNewRegisterRequestBinding
import com.idiot.more.ui.adapter.RegisterNewInquiryAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewRegisterRequestFragment : Fragment() {

  private lateinit var binding: FragmentNewRegisterRequestBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {

    binding = FragmentNewRegisterRequestBinding.inflate(inflater, container, false)
    binding.registerRequestList.adapter = RegisterNewInquiryAdapter(RegisterSample())

    fabButtonClicked()

    return binding.root
  }

  private fun fabButtonClicked() {
    binding.fabButton.setOnClickListener {
      val direction = RegisterFragmentDirections.actionRegisterFragmentToRequestOwnerToBrokerFragment()
      findNavController().navigate(direction)
    }
  }
}