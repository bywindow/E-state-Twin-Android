package com.idiot.more.ui

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.idiot.more.R
import com.idiot.more.databinding.FragmentRegisterHouseInfoBinding
import com.idiot.more.ui.adapter.BuildingTypeSpinnerAdapter
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import java.util.*

@AndroidEntryPoint
class RegisterHouseInfoFragment : BottomSheetDialogFragment() {

  private lateinit var binding: FragmentRegisterHouseInfoBinding
  private lateinit var viewModel: RegisterInfoViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setStyle(STYLE_NORMAL, R.style.Theme_idiot_BottomSheet_Rounded)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    viewModel = ViewModelProvider(requireParentFragment().childFragmentManager.fragments[0])[RegisterInfoViewModel::class.java]
    binding = DataBindingUtil.inflate(
      inflater, R.layout.fragment_register_house_info, container, false
    )
    binding.lifecycleOwner = viewLifecycleOwner
    binding.vm = viewModel
    binding.closeButton.setOnClickListener { dismiss() }
    initInputBox()
    initSpinners(binding)
    initDatePicker()
    completeButtonClicked()
    return binding.root
  }
  
  private fun initSpinners(binding: FragmentRegisterHouseInfoBinding) {
    val buildingTypeAdapter = BuildingTypeSpinnerAdapter(
      requireContext(),
      R.layout.list_item_building_type_spinner,
      resources.getStringArray(R.array.building_type_list)
    )
    binding.buildingTypeSelector.adapter = buildingTypeAdapter
    binding.buildingTypeSelector.setSelection(viewModel.estateType.value)
    binding.buildingTypeSelector.onItemSelectedListener =
      object : AdapterView.OnItemSelectedListener {
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
    binding.heatTypeSelector.setSelection(viewModel.heatType.value)
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
    binding.roomTypeSelector.setSelection(viewModel.roomType.value)
    binding.roomTypeSelector.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
      override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        viewModel.changeRoomType(position)
      }

      override fun onNothingSelected(parent: AdapterView<*>?) {
        return
      }
    }
  }

  private fun initInputBox() {
    if (viewModel.buildingName.value != "") {
      binding.buildingNameInput.setText(viewModel.buildingName.value)
    }
    if (viewModel.totalBuildingFloor.value != 0) {
      binding.buildingTotalFloorInput.setText(viewModel.totalBuildingFloor.value.toString())
    }
    if (viewModel.curBuildingFloor.value != 0) {
      binding.buildingCurrentFloorInput.setText(viewModel.curBuildingFloor.value.toString())
    }
    if (viewModel.netArea.value != 0.0f) {
      binding.netAreaInput.setText(viewModel.netArea.value.toString())
    }
    if (viewModel.area.value != 0.0f) {
      binding.areaInput.setText(viewModel.area.value.toString())
    }

  }
  
  private fun initDatePicker() {
    if (viewModel.availableDate.value.isNotEmpty()) {
      val date = viewModel.availableDate.value
      binding.datePicker.text = "${date[0]}년 ${date[1]}월 ${date[2]}일"
    }
    binding.datePicker.setOnClickListener {
      val calendar = Calendar.getInstance()
      val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
        val monthString = if (month < 9) "0${month+1}" else "${month+1}"
        val dayOfMonthString = if (dayOfMonth < 10) "0$dayOfMonth" else dayOfMonth.toString()
        binding.datePicker.text = "${year}년 ${monthString}월 ${dayOfMonthString}일"
        viewModel.changeAvailableDate("$year", monthString, dayOfMonthString)
      }
      DatePickerDialog(context!!, dateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show()
    }
  }

  private fun completeButtonClicked() {
    binding.completeButton.setOnClickListener {
      saveTextInputField()
      findNavController().navigateUp()
    }
  }

  private fun saveTextInputField() {
    viewModel.changeBuildingName(binding.buildingNameInput.text.toString())
    viewModel.changeTotalBuildingFloor(binding.buildingTotalFloorInput.text.toString().toInt())
    viewModel.changeCurBuildingFloor(binding.buildingCurrentFloorInput.text.toString().toInt())
    viewModel.changeNetArea(binding.netAreaInput.text.toString().toFloat())
    viewModel.changeArea(binding.areaInput.text.toString().toFloat())
  }
}