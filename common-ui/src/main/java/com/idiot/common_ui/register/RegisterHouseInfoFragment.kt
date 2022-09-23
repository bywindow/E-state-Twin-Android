package com.idiot.common_ui.register

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar
import com.idiot.common_ui.R
import com.idiot.common_ui.databinding.FragmentRegisterHouseInfoBinding
import com.idiot.common_ui.register.adapters.BuildingTypeSpinnerAdapter

class RegisterHouseInfoFragment : BottomSheetDialogFragment() {

  private lateinit var binding: FragmentRegisterHouseInfoBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setStyle(STYLE_NORMAL, R.style.Theme_idiot_BottomSheet_Rounded)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(
      inflater, R.layout.fragment_register_house_info, container, false
    )
    binding.closeButton.setOnClickListener {
      dismiss()
    }
    initSpinners(binding)
    return binding.root
  }

  //TODO : save data function
  private fun initSpinners(binding: FragmentRegisterHouseInfoBinding) {
    val buildingTypeAdapter = BuildingTypeSpinnerAdapter(
      requireContext(),
      R.layout.list_item_building_type_spinner,
      resources.getStringArray(R.array.building_type_list)
    )
    binding.buildingTypeSelector.adapter = buildingTypeAdapter

    val heatTypeAdapter = BuildingTypeSpinnerAdapter(
      requireContext(),
      R.layout.list_item_building_type_spinner,
      resources.getStringArray(R.array.heat_type_list)
    )
    binding.heatTypeSelector.adapter = heatTypeAdapter

    val roomTypeAdapter = BuildingTypeSpinnerAdapter(
      requireContext(),
      R.layout.list_item_building_type_spinner,
      resources.getStringArray(R.array.room_type_list)
    )
    binding.roomTypeSelector.adapter = roomTypeAdapter
  }
}