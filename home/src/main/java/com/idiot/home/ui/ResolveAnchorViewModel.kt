package com.idiot.home.ui

import androidx.lifecycle.ViewModel
import com.idiot.model.AssetIncludingChecklist
import com.idiot.model.Checklist
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ResolveAnchorViewModel @Inject constructor() : ViewModel() {

  private val _anchorList = MutableStateFlow<List<AssetIncludingChecklist>>(emptyList())
  val anchorList = _anchorList.asStateFlow()

  fun fetchAnchorList(list: List<AssetIncludingChecklist>) {
    _anchorList.value = list
    Timber.d("AR ANCHOR: $list")
  }
}