package com.idiot.userhouse.ui

import androidx.lifecycle.ViewModel
import com.idiot.data.repository.OwnerModeRepository
import com.idiot.model.OwnerModeResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class OwnerModeViewModel @Inject constructor(
  private val ownerModeRepository: OwnerModeRepository
) : ViewModel() {

  private val _ownerEstateList = MutableStateFlow<List<OwnerModeResponse>>(emptyList())
  val ownerEstateList = _ownerEstateList.asStateFlow()

  fun getOwnerList() = flow {
    val response = ownerModeRepository.requestOwnerMode()
    _ownerEstateList.value = response
    emit(OwnerModeStatus.FetchSuccess(response))
  }
}

sealed class OwnerModeStatus {
  class FetchSuccess(val list: List<OwnerModeResponse>) : OwnerModeStatus()
}