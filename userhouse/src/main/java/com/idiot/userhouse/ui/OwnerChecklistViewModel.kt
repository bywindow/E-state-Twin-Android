package com.idiot.userhouse.ui

import androidx.lifecycle.ViewModel
import com.idiot.data.repository.OwnerModeRepository
import com.idiot.model.AssetIncludingChecklist
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class OwnerChecklistViewModel @Inject constructor(
  private val ownerModeRepository: OwnerModeRepository
) : ViewModel() {

  private val _assetList = MutableStateFlow(emptyList<AssetIncludingChecklist>())
  val assetList = _assetList.asStateFlow()

  val homeApplianceFiltered = MutableStateFlow(emptyList<AssetIncludingChecklist>())
  val furnitureFiltered = MutableStateFlow(emptyList<AssetIncludingChecklist>())
  val bathroomFiltered = MutableStateFlow(emptyList<AssetIncludingChecklist>())
  val interiorFiltered = MutableStateFlow(emptyList<AssetIncludingChecklist>())

  fun fetchAssetList(estateId: Long) = flow {
    val response = ownerModeRepository.requestOwnerAssetList(estateId)
    _assetList.value = response
    homeApplianceFiltered.value = response.filter { it.category == "HOMEAPPLIANCES" }
    furnitureFiltered.value = response.filter { it.category == "FURNITURE" }
    bathroomFiltered.value = response.filter { it.category == "BATHROOM" }
    interiorFiltered.value = response.filter { it.category == "INTERIOR" }
    Timber.d("$response")
    emit(OwnerCheckListStatus.FetchSuccess)
  }

}

sealed class OwnerCheckListStatus {
  object FetchSuccess : OwnerCheckListStatus()
}