package com.idiot.userhouse.ui

import androidx.lifecycle.ViewModel
import com.idiot.data.repository.TenantModeRepository
import com.idiot.model.AssetIncludingChecklist
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ManageAssetViewModel @Inject constructor(
  private val tenantModeRepository: TenantModeRepository
) : ViewModel() {

  private val _assetList = MutableStateFlow<List<AssetIncludingChecklist>>(emptyList())
  val assetList = _assetList.asStateFlow()

  fun fetchAssetList(category: String) = flow {
    val response = tenantModeRepository.requestGetTenantAssetList(category)
    Timber.d("VM : $response")
    _assetList.value = response
    emit(TenantModeStatus.GetAssetListSuccess)
  }
}

sealed class TenantModeStatus {
  object GetAssetListSuccess : TenantModeStatus()
}