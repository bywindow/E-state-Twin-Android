package com.idiot.more.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.idiot.data.repository.samples.RegisterSample
import com.idiot.more.databinding.FragmentNewRegisterRequestBinding
import com.idiot.more.ui.adapter.RegisterNewInquiryAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import timber.log.Timber

@AndroidEntryPoint
class NewRegisterRequestFragment : Fragment() {

  private lateinit var binding: FragmentNewRegisterRequestBinding
  private val viewModel: NewRegisterRequestViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {

    binding = FragmentNewRegisterRequestBinding.inflate(inflater, container, false)
    binding.registerRequestList.adapter = RegisterNewInquiryAdapter(viewModel.estateList.value)

    fabButtonClicked()
    getEstateList()

    return binding.root
  }

  private fun fabButtonClicked() {
    binding.fabButton.setOnClickListener {
      val direction =
        RegisterFragmentDirections.actionRegisterFragmentToRequestOwnerToBrokerFragment()
      findNavController().navigate(direction)
    }
  }

  private fun getEstateList() {
    viewLifecycleOwner.lifecycleScope.launch {
      viewModel.getEstateList().collect() {
        binding.registerRequestList.adapter = RegisterNewInquiryAdapter(viewModel.estateList.value)
      }
    }
  }
}