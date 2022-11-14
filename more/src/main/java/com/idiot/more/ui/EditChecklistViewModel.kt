package com.idiot.more.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idiot.data.repository.RegisterCheckListRepository
import com.idiot.model.AssetIncludingChecklist
import com.idiot.model.Checklist
import com.idiot.model.RegisterCheckList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class EditChecklistViewModel @Inject constructor(
  private val registerCheckListRepository: RegisterCheckListRepository
) : ViewModel() {

  private val _repairType = MutableStateFlow(0)
  val repairType = _repairType.asStateFlow()

  private val _assetInit = MutableStateFlow<AssetIncludingChecklist?>(null)
  val assetInit = _assetInit.asStateFlow()

  private val _checklistImageUrl = MutableStateFlow("")
  val checklistImageUrl = _checklistImageUrl.asStateFlow()

  private val _checklistDetail = MutableStateFlow<List<RegisterCheckList>>(emptyList())
  val checklistDetail = _checklistDetail.asStateFlow()

  fun changeRepairType(type: Int) {
    _repairType.value = type
  }

  fun initChecklistInfo(info: AssetIncludingChecklist?) {
    _assetInit.value = info
    _checklistImageUrl.value = info?.assetPhoto.toString()
  }

  fun saveInputField(manufacturer: String, productName: String, flawPart: String, description: String, repairDate: String, estateId: Long) = flow {
    _assetInit.value?.apply {
      this.manufacturer = manufacturer
      this.productName = productName
    }
    val mChecklist = RegisterCheckList(
      flawPart = flawPart,
      checkListContent = description,
      repairDate = repairDate,
      repairType = if (repairType.value == 1) "PURCHASE" else "REPAIR",
      checkListPhoto = checklistImageUrl.value
    )
    val response = registerCheckListRepository.requestPostingCheckList(estateId, assetInit.value!!.id, mChecklist)
    if (response != null) {
      emit(CheckListStatus.CheckListPostingSuccess(response))
    } else {
      emit(CheckListStatus.CheckListPostingFailed)
    }
  }
}

sealed class CheckListStatus {
  class CheckListPostingSuccess(val response: Checklist) : CheckListStatus()
  object CheckListPostingFailed : CheckListStatus()
}