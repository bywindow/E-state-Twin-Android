package com.idiot.userhouse.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idiot.data.repository.R
import com.idiot.data.repository.TenantModeRepository
import com.idiot.model.TenantModeResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class TenantModeViewModel @Inject constructor(
  private val tenantModeRepository: TenantModeRepository
): ViewModel() {

  private val _tenantEstate = MutableStateFlow<TenantModeResponse?>(null)
  val tenantEstate = _tenantEstate.asStateFlow()

  val assetManageTabTitles = arrayListOf<String>("가전", "가구", "욕실/주방", "인테리어")
  val assetCategoryKeys = arrayListOf<String>("HOMEAPPLIANCES", "FURNITURE", "BATHROOM", "INTERIOR")
  val assetManageTabIcons = arrayListOf<Int>(
    R.drawable.ic_option_laundry,
    R.drawable.ic_option_bed,
    R.drawable.ic_option_sink,
    R.drawable.ic_option_curtain
  )
  val contractTabTitles = arrayListOf<String>("계약서 보기", "특이사항")
  val contractTabIcons = arrayListOf<Int>(
    R.drawable.ic_document, R.drawable.ic_special
  )

  init {
    viewModelScope.launch {
      Timber.d("TENANT MODE")
      _tenantEstate.value = tenantModeRepository.requestGetTenantMode()
      Timber.d("TENANT MODE : ${tenantEstate.value}")
    }
  }

}