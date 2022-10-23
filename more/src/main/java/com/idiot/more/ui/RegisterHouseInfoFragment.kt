package com.idiot.more.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.idiot.more.R
import com.idiot.more.databinding.FragmentRegisterHouseInfoBinding
import com.idiot.more.ui.adapter.BuildingTypeSpinnerAdapter
import timber.log.Timber

class RegisterHouseInfoFragment : BottomSheetDialogFragment() {

  private lateinit var binding: FragmentRegisterHouseInfoBinding
  private val viewModel: RegisterInfoViewModel by viewModels()

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
    binding.buildingTypeSelector.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
      override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Timber.d("CHANGE**************  $position")
      }
      override fun onNothingSelected(parent: AdapterView<*>?) {
        return
      }
    }

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