package com.idiot.more.ui

import androidx.lifecycle.ViewModel
import com.idiot.model.HouseOption
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class RegisterARViewModel @Inject constructor() : ViewModel() {

  private val _assetList = MutableStateFlow(emptyList<HouseOption>())
  val assetList: StateFlow<List<HouseOption>> = _assetList

  fun initAssetList(items: List<HouseOption>) {
    _assetList.value = items
    Timber.d("ASSET : ${assetList.value}")
  }
}