package com.idiot.more.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.idiot.more.R
import com.idiot.more.databinding.FragmentRegisterPriceInfoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterPriceInfoFragment : BottomSheetDialogFragment() {

  private lateinit var binding: FragmentRegisterPriceInfoBinding
  private lateinit var viewModel: RegisterInfoViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setStyle(STYLE_NORMAL, R.style.Theme_idiot_BottomSheet_Rounded)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register_price_info, container, false)
    viewModel = ViewModelProvider(requireParentFragment().childFragmentManager.fragments[0])[RegisterInfoViewModel::class.java]
    binding.lifecycleOwner = viewLifecycleOwner
    binding.vm = viewModel

    completeButtonClicked()

    return binding.root
  }

  private fun completeButtonClicked() {
    binding.completeButton.setOnClickListener {
      saveInputField()
      findNavController().navigateUp()
    }
  }

  private fun saveInputField() {
    viewModel.changeDeposit(binding.depositInput.text.toString().toInt())
    viewModel.changeMonthly(binding.monthlyInput.text.toString().toInt())
    viewModel.changeManagementFee(binding.managementFeeInput.text.toString().toInt())
    viewModel.changeParkingFee(binding.parkingFeeInput.text.toString().toInt())
  }
}