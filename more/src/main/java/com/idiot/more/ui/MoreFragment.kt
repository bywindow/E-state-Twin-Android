package com.idiot.more.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.idiot.more.R
import com.idiot.more.databinding.FragmentMoreBinding
import com.idiot.more.ui.viewModel.MoreViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MoreFragment : Fragment() {

  private lateinit var binding: FragmentMoreBinding
  private val viewModel: MoreViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    super.onCreateView(inflater, container, savedInstanceState)
    binding = DataBindingUtil.inflate(
      inflater, R.layout.fragment_more, container, false
    )

    subscribeUi(binding)
    navigateTo()

    return binding.root
  }

  private fun subscribeUi(binding: FragmentMoreBinding) {
//    binding.userNameTextView.text = "홍길동"
//    binding.userRoleTextView.text = "기업회원"
    viewLifecycleOwner.lifecycleScope.launch {
      viewModel.fetchUserInfo().collect() {
        val value = viewModel.userInfo.value
        binding.model = value
      }
    }
  }

  // TODO: Add another tab button clickListener
  private fun navigateTo() {
    binding.register.setClickListener {
      val directions = MoreFragmentDirections.actionMoreFragmentToRegisterFragment()
      it.findNavController().navigate(directions)
    }
    binding.refactorUser.setClickListener {
      val directions = MoreFragmentDirections.actionMoreFragmentToMyPageFragment()
      it.findNavController().navigate(directions)
    }
  }
}