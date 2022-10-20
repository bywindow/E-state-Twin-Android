package com.idiot.more.ui.viewModel

import android.content.ClipData
import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.*
import com.idiot.data.repository.EstateImageS3UploadRepository
import com.idiot.model.RegisterEstatePicture
import com.idiot.more.util.FileUtil
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.*
import kotlin.random.Random

class RegisterPictureListViewModel(
  private val activity: FragmentActivity,
  private val repository: EstateImageS3UploadRepository
  ) : AndroidViewModel(activity.application) {
  private val _pictureList = MutableLiveData<List<RegisterEstatePicture>>()
  val pictureList: LiveData<List<RegisterEstatePicture>>
    get() = _pictureList

  fun insertPicture(clipData: ClipData, size: Int) {
    viewModelScope.launch {
      val currentList = _pictureList.value
      val updatedList = currentList?.toMutableList() ?: mutableListOf<RegisterEstatePicture>()
      val imageFormList = mutableListOf<String>()
      (0 until size).forEach {
        val newItem = RegisterEstatePicture(
          Random.nextLong(),
          UUID.randomUUID().toString(),
          clipData.getItemAt(it).uri
        )
        updatedList.add(newItem)
        Timber.d("${clipData.getItemAt(it).uri}")
        FileUtil.getImageFilePath(context = activity, uri = clipData.getItemAt(it).uri)
          ?.let { it1 -> imageFormList.add(it1) }
      }
      _pictureList.postValue(updatedList)
      Timber.d("s3 new list: $updatedList")
      val response = repository.requestImageUri(imageFormList[0])
      Timber.d("s3 image: $response")
    }
  }

  fun deletePicture(item: RegisterEstatePicture) {
    //TODO : delete selected photo
    Log.d("register", "delete! $item")
  }

  class PictureListFactory(private val activity: FragmentActivity) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
      if (modelClass.isAssignableFrom(RegisterPictureListViewModel::class.java)) {
        @Suppress("UNCHECKED_CAST")
        return RegisterPictureListViewModel(activity, EstateImageS3UploadRepository()) as T
      }
      throw IllegalArgumentException("Unknown ViewModel class")
    }
  }
}