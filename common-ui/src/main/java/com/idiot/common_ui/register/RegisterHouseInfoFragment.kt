package com.idiot.common_ui.register

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.idiot.common_ui.R
import com.idiot.common_ui.databinding.FragmentRegisterHouseInfoBinding
import com.idiot.common_ui.register.adapters.BuildingTypeSpinnerAdapter
import com.idiot.di.screenRectDp

class RegisterHouseInfoFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentRegisterHouseInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.Theme_idiot_BottomSheet_Rounded)
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
        Toast.makeText(requireContext(), "입력 정보가 저장되었습니다.", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_register_house_info, container, false
        )
//        Log.d("register", "${(screenRectDp.height() * 0.8).toInt()}")
        initBuildingTypeSpinner(binding)
        initHeatTypeSpinner(binding)
        return binding.root
    }

    private fun initBuildingTypeSpinner(binding: FragmentRegisterHouseInfoBinding) {
        val adapter = BuildingTypeSpinnerAdapter(requireContext(), R.layout.list_item_building_type_spinner, resources.getStringArray(R.array.building_type_list))
        binding.buildingTypeSelector.adapter = adapter
    }

    private fun initHeatTypeSpinner(binding: FragmentRegisterHouseInfoBinding) {
        val adapter = BuildingTypeSpinnerAdapter(requireContext(), R.layout.list_item_building_type_spinner, resources.getStringArray(R.array.heat_type_list))
        binding.heatTypeSelector.adapter = adapter
    }

}