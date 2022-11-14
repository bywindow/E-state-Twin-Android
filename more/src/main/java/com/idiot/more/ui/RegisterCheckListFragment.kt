package com.idiot.more.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.idiot.more.R
import com.idiot.more.databinding.FragmentRegisterCheckListBinding
import com.idiot.more.ui.adapter.RegisterCheckListOwnerAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class RegisterCheckListFragment : Fragment() {

  private lateinit var binding: FragmentRegisterCheckListBinding
  private val viewModel: RegisterCheckListViewModel by viewModels()
  private val args: RegisterInfoFragmentArgs by navArgs()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register_check_list, container, false)
    binding.apply {
      lifecycleOwner = this@RegisterCheckListFragment
      vm = viewModel
      adapter = RegisterCheckListOwnerAdapter(args.estateId)
    }

    initEstateDetail()
    subscribeUI()

    return binding.root
  }

  private fun initEstateDetail() {
    viewLifecycleOwner.lifecycleScope.launch {
      viewModel.fetchEstateDetails(args.estateId).collect() {
        when (it) {
          is RegisterCheckListState.FetchEstateSuccess -> {
            Timber.d("SUCCESS : ${it.estate}")
          }
          else -> {}
        }
      }
    }
  }

  private fun subscribeUI() {
    binding.completeButton.setOnClickListener {
      viewLifecycleOwner.lifecycleScope.launch {
        viewModel.requestConfirm(args.estateId).collect(){
          when (it) {
            is RegisterCheckListState.ConfirmSuccess -> {
              Timber.d("success : ${it.response}")
              findNavController().navigateUp()
            }
            else -> {
              Toast.makeText(requireContext(), "다시 시도해주세요.", Toast.LENGTH_SHORT).show()
            }
          }
        }
      }
    }
  }
}