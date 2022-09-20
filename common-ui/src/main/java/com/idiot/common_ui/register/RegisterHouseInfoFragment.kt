package com.idiot.common_ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.idiot.common_ui.R
import com.idiot.common_ui.databinding.FragmentRegisterHouseInfoBinding
import com.idiot.common_ui.register.adapters.BuildingTypeSpinnerAdapter

class RegisterHouseInfoFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentRegisterHouseInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.Theme_idiot_BottomSheet)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_register_house_info, container, false
        )
        initBuildingTypeSpinner(binding)
        return binding.root
    }

    private fun initBuildingTypeSpinner(binding: FragmentRegisterHouseInfoBinding) {
        val adapter = BuildingTypeSpinnerAdapter(requireContext(), R.layout.list_item_building_type_spinner, resources.getStringArray(R.array.building_type_list))
        binding.buildingTypeSelector.adapter = adapter
    }

}