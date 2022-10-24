package com.idiot.more.ui

import android.app.DatePickerDialog
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
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
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
    binding.lifecycleOwner = this
    binding.vm = viewModel
    binding.closeButton.setOnClickListener {
      dismiss()
    }
    initSpinners(binding)
    initDatePicker()
    return binding.root
  }
  
  private fun initSpinners(binding: FragmentRegisterHouseInfoBinding) {
    val buildingTypeAdapter = BuildingTypeSpinnerAdapter(
      requireContext(),
      R.layout.list_item_building_type_spinner,
      resources.getStringArray(R.array.building_type_list)
    )
    binding.buildingTypeSelector.adapter = buildingTypeAdapter
    binding.buildingTypeSelector.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
      override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        viewModel.changeEstateType(position)
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
    binding.heatTypeSelector.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
      override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        viewModel.changeHeatType(position)
      }
      override fun onNothingSelected(parent: AdapterView<*>?) {
        return
      }
    }

    val roomTypeAdapter = BuildingTypeSpinnerAdapter(
      requireContext(),
      R.layout.list_item_building_type_spinner,
      resources.getStringArray(R.array.room_type_list)
    )
    binding.roomTypeSelector.adapter = roomTypeAdapter
    binding.roomTypeSelector.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
      override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        viewModel.changeRoomType(position)
      }
      override fun onNothingSelected(parent: AdapterView<*>?) {
        return
      }
    }
  }
  
  private fun initDatePicker() {
    binding.datePicker.setOnClickListener {
      val calendar = Calendar.getInstance()
      val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
        binding.datePicker.text = "${year}년 ${month+1}월 ${dayOfMonth}일"
        viewModel.changeAvailableDate(year, month, dayOfMonth)
      }
      DatePickerDialog(context!!, dateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show()
    }
  }
}