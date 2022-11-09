package com.idiot.home.ui

import androidx.lifecycle.ViewModel
import com.idiot.model.AssetIncludingChecklist
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ResolveAnchorViewModel @Inject constructor() : ViewModel() {
  private val _anchorList = MutableStateFlow<List<AssetIncludingChecklist>>(emptyList())
  val anchorList = _anchorList.asStateFlow()

  fun fetchAnchorList(list: List<AssetIncludingChecklist>) {
    _anchorList.value = list
  }
}