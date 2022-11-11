package com.idiot.more.ui

import androidx.lifecycle.ViewModel
import com.idiot.data.repository.GetEstateDetailRepository
import com.idiot.model.AssetIncludingChecklist
import com.idiot.model.DetailEstate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class RegisterCheckListViewModel @Inject constructor(
  private val getEstateDetailRepository: GetEstateDetailRepository
) : ViewModel() {
  private val _detailEstate = MutableStateFlow<DetailEstate?>(null)
  val detailEstate = _detailEstate.asStateFlow()

  private val _assetList = MutableStateFlow<List<AssetIncludingChecklist>>(emptyList())
  val assetList = _assetList.asStateFlow()

  val selectedCategory = MutableStateFlow(0)
  private val categories = listOf("HOMEAPPLIANCES", "FURNITURE", "BATHROOM", "INTERIOR")
  val filteredAssetList = assetList.value.filter { it.category == categories[selectedCategory.value] }

  fun fetchEstateDetails(estateId: Long) = flow {
    val response = getEstateDetailRepository.requestGetDetailEstate(estateId)
    Timber.d("Detail VM : $response")
    _detailEstate.value = response
    if (response != null) {
      emit(RegisterCheckListState.FetchEstateSuccess(response))
    } else {
      emit(RegisterCheckListState.FetchEstateFailed)
    }
  }
}

sealed class RegisterCheckListState {
  class FetchEstateSuccess(val estate: DetailEstate) : RegisterCheckListState()
  object FetchEstateFailed : RegisterCheckListState()
}