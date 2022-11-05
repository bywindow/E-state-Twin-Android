package com.idiot.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idiot.data.repository.GetEstateDetailRepository
import com.idiot.model.DetailEstate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HouseDetailViewModel @Inject constructor(
  private val getEstateDetailRepository: GetEstateDetailRepository
) : ViewModel() {
  private val _detailEstate = MutableStateFlow<DetailEstate?>(null)
  val detailEstate = _detailEstate.asStateFlow()

  fun fetchEstateDetail(estateId: Int) {
    viewModelScope.launch {
      getEstateDetailRepository.requestGetDetailEstate(estateId).collect {
        _detailEstate.value = it
      }
    }
  }
}