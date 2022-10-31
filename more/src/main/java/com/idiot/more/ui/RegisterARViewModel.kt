package com.idiot.more.ui

import androidx.lifecycle.ViewModel
import com.idiot.model.DetailAsset
import com.idiot.model.HouseOption
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class RegisterARViewModel @Inject constructor() : ViewModel() {

  private val _optionList = MutableStateFlow(emptyList<HouseOption>())
  val optionList: StateFlow<List<HouseOption>> = _optionList

  private val _assetList = MutableStateFlow(emptyList<DetailAsset>())
  val assetList: StateFlow<List<DetailAsset>> = _assetList

  private val _assetCursor = MutableStateFlow(0)
  val assetCursor: StateFlow<Int> = _assetCursor

  private val _mappedAssetAnchor = MutableStateFlow(emptyMap<Int, String>())
  val mappedAssetAnchor: StateFlow<Map<Int, String>> = _mappedAssetAnchor

  fun initAssetList(items: List<HouseOption>) {
    _optionList.value = items
    val nList: MutableList<DetailAsset> = emptyList<DetailAsset>().toMutableList()
    items.forEach {
      val temp = DetailAsset(id = it.id, category = it.category, option = it.key, productName = null, manufacturer = null, anchorId = null, assetPhoto = null, repairDate = null)
      nList.add(temp)
    }
    _assetList.value = nList
    Timber.d("ASSET : ${assetList.value}")
  }

  fun changeAssetCursor(position: Int) {
    _assetCursor.value = position
    Timber.d("ASSET CURSOR : ${assetCursor.value}")
  }

  fun mappingAnchorToAsset(assetId: Int, anchorId: String) {
    val temp = _mappedAssetAnchor.value.toMutableMap()
    temp[assetId] = anchorId
    _mappedAssetAnchor.value = temp
    Timber.d("ASSET MAP : ${mappedAssetAnchor.value}")
  }
}