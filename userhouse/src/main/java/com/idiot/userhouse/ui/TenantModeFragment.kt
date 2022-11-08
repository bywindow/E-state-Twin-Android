package com.idiot.userhouse.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.idiot.userhouse.R
import com.idiot.userhouse.databinding.FragmentTenantModeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TenantModeFragment : Fragment() {

  private lateinit var binding: FragmentTenantModeBinding
  private val viewModel: TenantModeViewModel by viewModels()
  private lateinit var assetLinearLayout: LinearLayoutCompat
  private lateinit var contractLinearLayout: LinearLayoutCompat

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tenant_mode, container, false)
    binding.lifecycleOwner = viewLifecycleOwner
    binding.vm = viewModel

    assetLinearLayout = binding.assetManageTabListLayout
    contractLinearLayout = binding.contractTabListLayout

    subscribeUi(binding, viewModel)
    return binding.root
  }

  private fun subscribeUi(binding: FragmentTenantModeBinding, viewModel: TenantModeViewModel) {

    viewModel.assetManageTabTitles.forEachIndexed { index, title ->
      val tabView =
        LayoutInflater.from(requireContext()).inflate(R.layout.layout_myhouse_tab, null, false)
      tabView.findViewById<TextView>(R.id.tab_title).text = title
      tabView.findViewById<ImageView>(R.id.tab_icon)
        .setImageResource(viewModel.assetManageTabIcons[index])
      assetLinearLayout.addView(tabView)
    }

    viewModel.contractTabTitles.forEachIndexed { index, title ->
      val tabView =
        LayoutInflater.from(requireContext()).inflate(R.layout.layout_myhouse_tab, null, false)
      tabView.findViewById<TextView>(R.id.tab_title).text = title
      tabView.findViewById<ImageView>(R.id.tab_icon)
        .setImageResource(viewModel.contractTabIcons[index])
      contractLinearLayout.addView(tabView)
    }
  }

}