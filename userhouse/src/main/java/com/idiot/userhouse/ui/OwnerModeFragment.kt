package com.idiot.userhouse.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.idiot.userhouse.R
import com.idiot.userhouse.databinding.FragmentOwnerModeBinding
import com.idiot.data.repository.samples.OwnerHouseSample
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class OwnerModeFragment : Fragment() {

  private lateinit var binding: FragmentOwnerModeBinding
  private val viewModel: OwnerModeViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = DataBindingUtil.inflate<FragmentOwnerModeBinding?>(
      inflater, R.layout.fragment_owner_mode, container, false
    )
    getOwnerList()
    return binding.root
  }

  private fun getOwnerList() {
    viewLifecycleOwner.lifecycleScope.launch {
      viewModel.getOwnerList().collect() {
        Timber.d("response : ${it.list}")
      }
    }
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    binding.apply {
      lifecycleOwner = this@OwnerModeFragment
      adapter = OwnerHouseAdapter()
      vm = viewModel
    }
  }

}