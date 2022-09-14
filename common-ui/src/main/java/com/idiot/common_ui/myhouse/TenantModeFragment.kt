package com.idiot.common_ui.myhouse

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.idiot.common.myhouse.viewmodels.TenantModeViewModel
import com.idiot.common_ui.R
import com.idiot.common_ui.databinding.FragmentTenantModeBinding

class TenantModeFragment : Fragment() {

    private lateinit var binding: FragmentTenantModeBinding
    private lateinit var viewModel: TenantModeViewModel
    private lateinit var assetLinearLayout: LinearLayoutCompat
    private lateinit var contractLinearLayout: LinearLayoutCompat

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tenant_mode, container, false)
        viewModel = ViewModelProvider(requireActivity(), TenantModeViewModel.Factory(
            Application()
        )).get(TenantModeViewModel::class.java)

        assetLinearLayout = binding.assetManageTabListLayout
        contractLinearLayout = binding.contractTabListLayout

        subscribeUi(binding, viewModel)
        return binding.root
    }

    private fun subscribeUi(binding: FragmentTenantModeBinding, viewModel: TenantModeViewModel) {
        viewModel.assetManageTabTitles.forEachIndexed { index, title ->
            val tabView = LayoutInflater.from(requireContext()).inflate(R.layout.layout_myhouse_tab, null, false)
            tabView.findViewById<TextView>(R.id.tab_title).text = title
            tabView.findViewById<ImageView>(R.id.tab_icon).setImageResource(viewModel.assetManageTabIcons[index])
            assetLinearLayout.addView(tabView)
        }

        viewModel.contractTabTitles.forEachIndexed { index, title ->
            val tabView = LayoutInflater.from(requireContext()).inflate(R.layout.layout_myhouse_tab, null, false)
            tabView.findViewById<TextView>(R.id.tab_title).text = title
            tabView.findViewById<ImageView>(R.id.tab_icon).setImageResource(viewModel.contractTabIcons[index])
            contractLinearLayout.addView(tabView)
        }
    }

}