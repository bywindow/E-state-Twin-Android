package com.idiot.home.ui

import androidx.lifecycle.ViewModel
import com.idiot.data.repository.GetEstateDetailRepository
import com.idiot.model.AssetIncludingChecklist
import com.idiot.model.Checklist
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ResolveAnchorViewModel @Inject constructor(
  private val getEstateDetailRepository: GetEstateDetailRepository
) : ViewModel() {

  private val _anchorList = MutableStateFlow<List<AssetIncludingChecklist>>(emptyList())
  val anchorList = _anchorList.asStateFlow()

  private val _anchorDetail = MutableStateFlow<AssetIncludingChecklist?>(null)
  val anchorDetail = _anchorDetail.asStateFlow()

  fun fetchAnchorList(list: List<AssetIncludingChecklist>) {
    _anchorList.value = list
    Timber.d("AR ANCHOR: $list")
  }

  fun fetchChecklist(assetId: Long) = flow {
    val response = getEstateDetailRepository.requestGetAssets(assetId)
    _anchorDetail.value = response
    Timber.d("AR ACTIVITY : $response")
    emit(AnchorStatus.FetchSuccess)
  }
}

sealed class AnchorStatus {
  object FetchSuccess : AnchorStatus()
}