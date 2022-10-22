package com.idiot.more.ui.viewModel

import android.app.Activity
import android.net.Uri
import android.util.Log
import androidx.lifecycle.*
import com.idiot.data.repository.EstateImageS3UploadRepository
import com.idiot.model.RegisterEstatePicture
import com.idiot.more.util.FileUtil
import kotlinx.coroutines.launch
import timber.log.Timber
import java.io.File
import kotlin.random.Random

class RegisterPictureListViewModel(
  activity: Activity,
  private val repository: EstateImageS3UploadRepository
  ) : AndroidViewModel(activity.application) {
  private val _pictureList = MutableLiveData<List<RegisterEstatePicture>>()
  val pictureList: LiveData<List<RegisterEstatePicture>>
    get() = _pictureList

  fun insertPicture(images: List<Uri>) {
    viewModelScope.launch {
      val currentList = _pictureList.value
      val updatedList = currentList?.toMutableList() ?: mutableListOf()
      val imageFormList = mutableListOf<File>()
      images.forEach {
        val newItem = RegisterEstatePicture(
          Random.nextLong(),
          it.toString().split("/").last(),
          it
        )
        updatedList.add(newItem)
        Timber.d("image uri : $it")
        val file: File = FileUtil.convertUriToFile(context = getApplication(), it)
        Timber.d("File Path VM: $file")
        imageFormList.add(file)
      }
      _pictureList.postValue(updatedList)
      Timber.d("s3 new list: $updatedList")
      val response = repository.requestImageUri(imageFormList)
      Timber.d("s3 image: $response")
    }
  }

  fun deletePicture(item: RegisterEstatePicture) {
    //TODO : delete selected photo
    Log.d("register", "delete! $item")
  }

  class PictureListFactory(private val activity: Activity) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
      if (modelClass.isAssignableFrom(RegisterPictureListViewModel::class.java)) {
        @Suppress("UNCHECKED_CAST")
        return RegisterPictureListViewModel(activity, EstateImageS3UploadRepository()) as T
      }
      throw IllegalArgumentException("Unknown ViewModel class")
    }
  }
}