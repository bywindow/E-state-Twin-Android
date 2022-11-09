package com.idiot.userhouse.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.idiot.userhouse.R
import com.idiot.userhouse.databinding.FragmentManageAssetBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ManageAssetFragment : Fragment() {

  private lateinit var binding: FragmentManageAssetBinding
  private val args: ManageAssetFragmentArgs by navArgs()
  private val viewModel: ManageAssetViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_manage_asset, container, false)
    binding.lifecycleOwner = viewLifecycleOwner
    binding.vm = viewModel
    binding.adapter = AssetListAdapter(viewModel.assetList.value)

    initAdapter()

    return binding.root
  }

  fun initAdapter() {
    viewLifecycleOwner.lifecycleScope.launch {
      viewModel.fetchAssetList(args.category).collect {
        binding.adapter = AssetListAdapter(viewModel.assetList.value)
      }
    }
  }

}