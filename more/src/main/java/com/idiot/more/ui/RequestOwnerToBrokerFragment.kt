package com.idiot.more.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.idiot.more.R
import com.idiot.more.databinding.FragmentRequestOwnerToBrokerBinding
import com.idiot.utils.NetworkStatus
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class RequestOwnerToBrokerFragment : Fragment() {

  private lateinit var binding: FragmentRequestOwnerToBrokerBinding
  private val viewModel: RequestOwnerToBrokerViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_request_owner_to_broker, container, false)
    binding.vm = viewModel

    initAddressSearchDialogListener()
    completeButtonClicked()

    return binding.root
  }

  private fun initAddressSearchDialogListener() {
    binding.searchAddressButton.setOnClickListener {
      val networkStatus = NetworkStatus()
      if (networkStatus.isNetworkAvailable(requireContext())) {
        val intent = Intent(context, SearchAddressActivity::class.java)
        getSearchAddressResult.launch(intent)
      } else {
        Snackbar.make(binding.root, "인터넷 연결을 확인해주세요.", Snackbar.LENGTH_SHORT).show()
      }
    }
  }

  private val getSearchAddressResult: ActivityResultLauncher<Intent> = registerForActivityResult(
    ActivityResultContracts.StartActivityForResult()
  ) {
    if (it.resultCode == Activity.RESULT_OK && it.data != null) {
      val data = it.data!!.getStringExtra("data")
      if (data != null) {
        viewModel.changeAddress(data)
        binding.roadTextView.text = data
        binding.searchResultView.visibility = View.VISIBLE
      }
    }
  }

  private fun completeButtonClicked() {
    binding.completeButton.setOnClickListener {
      viewLifecycleOwner.lifecycleScope.launch {
        viewModel.requestPostEstateOwner()
      }
      findNavController().navigateUp()
    }
  }
}