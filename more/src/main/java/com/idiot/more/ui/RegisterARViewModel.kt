package com.idiot.more.ui

import android.app.Application
import androidx.core.net.toUri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idiot.data.repository.EstateImageS3UploadRepository
import com.idiot.model.DetailAsset
import com.idiot.model.HouseOption
import com.idiot.more.util.FileUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import java.io.File
import javax.inject.Inject

@HiltViewModel
class RegisterARViewModel @Inject constructor(
  application: Application,
  private val estateImageS3UploadRepository: EstateImageS3UploadRepository
) : AndroidViewModel(application) {

  private val _optionList = MutableStateFlow(emptyList<HouseOption>())
  val optionList: StateFlow<List<HouseOption>> = _optionList

  private val _assetList = MutableStateFlow(emptyList<DetailAsset>())
  val assetList: StateFlow<List<DetailAsset>> = _assetList

  private val _assetCursor = MutableStateFlow(0)
  val assetCursor: StateFlow<Int> = _assetCursor

  val assetImageUri: MutableList<String> = emptyList<String>().toMutableList()

  fun initAssetList(items: List<HouseOption>) {
    _optionList.value = items
    val nList: MutableList<DetailAsset> = emptyList<DetailAsset>().toMutableList()
    items.forEach {
      val temp = DetailAsset(id = it.id, category = it.category, option = it.key, productName = null, manufacturer = null, anchorId = null, assetPhoto = null)
      nList.add(temp)
      assetImageUri.add("")
    }
    _assetList.value = nList
    Timber.d("ASSET : ${assetList.value}")
  }

  fun changeAssetCursor(position: Int) {
    _assetCursor.value = position
    Timber.d("ASSET CURSOR : ${assetCursor.value}")
  }

  fun addAssetAnchorId(anchorId: String) {
    _assetList.value[assetCursor.value].anchorId = anchorId
    Timber.d(("${assetList.value}"))
  }

  fun addAssetPhotoUri(uri: String) {
    _assetList.value[assetCursor.value].assetPhoto = uri
  }

  fun uploadAssetPhotoUri(file: File) {
    viewModelScope.launch {
      Timber.d("ASSET URI : $file")
      val response = estateImageS3UploadRepository.requestImageUri(listOf(file))
      Timber.d("ASSET PHOTO RES : $response")
      assetImageUri[assetCursor.value] = response.last().file_url
    }
  }

  fun saveAssetInfoField(productName: String, manufacturer: String) {
    _assetList.value[assetCursor.value].manufacturer = manufacturer
    _assetList.value[assetCursor.value].productName = productName
  }

  fun saveS3UriToAssetPhoto() {
    val temp = _assetList.value.toMutableList()
    temp.forEachIndexed { index, detailAsset ->
      detailAsset.assetPhoto = assetImageUri[index]
    }
    _assetList.value = temp.toList()
  }
}