package com.idiot.more.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.idiot.more.databinding.FragmentRegisterForBrokerBinding
import com.idiot.more.ui.adapter.RegisterNewInquiryAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegisterForBrokerFragment : Fragment() {

  private lateinit var binding: FragmentRegisterForBrokerBinding
  private val viewModel: RegisterForBrokerViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    super.onCreateView(inflater, container, savedInstanceState)

    binding = FragmentRegisterForBrokerBinding.inflate(inflater, container, false)
    binding.registerPostingList.adapter = RegisterNewInquiryAdapter(viewModel.postingEstate.value)

    getEstateList()

    return binding.root
  }

  private fun getEstateList() {
    viewLifecycleOwner.lifecycleScope.launch {
      viewModel.getPostingEstateList().collect {
        binding.registerPostingList.adapter = RegisterNewInquiryAdapter(viewModel.postingEstate.value)
      }
    }
  }

}