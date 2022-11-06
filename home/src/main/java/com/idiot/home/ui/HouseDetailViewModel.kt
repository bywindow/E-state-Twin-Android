package com.idiot.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idiot.data.repository.GetEstateDetailRepository
import com.idiot.model.AssetIncludingChecklist
import com.idiot.model.DetailEstate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HouseDetailViewModel @Inject constructor(
  private val getEstateDetailRepository: GetEstateDetailRepository
) : ViewModel() {
  private val _detailEstate = MutableStateFlow<DetailEstate?>(null)
  val detailEstate = _detailEstate.asStateFlow()

  private val _estateImageList = MutableStateFlow<List<String>>(emptyList())
  val estateImageList = _estateImageList.asStateFlow()

  private val _assetList = MutableStateFlow<List<AssetIncludingChecklist>>(emptyList())
  val assetList = _assetList.asStateFlow()

  fun fetchEstateDetail(estateId: Long) = flow {
    val response = getEstateDetailRepository.requestGetDetailEstate(estateId)
    Timber.d("Detail VM : $response")
    if (response != null) {
      _detailEstate.value = response
      _estateImageList.value = response.estatePhotos
      _assetList.value = response.assets
    }
    emit(EstateDetailEvent.GetEstateDetail)
  }
}

sealed class EstateDetailEvent {
  object GetEstateDetail : EstateDetailEvent()
}