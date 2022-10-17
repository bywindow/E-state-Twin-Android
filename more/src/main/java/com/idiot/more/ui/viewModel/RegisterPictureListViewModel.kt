package com.idiot.more.ui.viewModel

import android.content.ClipData
import android.util.Log
import androidx.lifecycle.*
import com.idiot.model.RegisterEstatePicture
import kotlinx.coroutines.launch
import java.util.*
import kotlin.random.Random

class RegisterPictureListViewModel() : ViewModel() {
  private val _pictureList = MutableLiveData<List<RegisterEstatePicture>>()
  val pictureList: LiveData<List<RegisterEstatePicture>>
    get() = _pictureList

  fun insertPicture(clipData: ClipData, size: Int) {
    viewModelScope.launch {
      val currentList = _pictureList.value
      val updatedList = currentList?.toMutableList() ?: mutableListOf<RegisterEstatePicture>()
      (0 until size).forEach {
        val newItem = RegisterEstatePicture(
          Random.nextLong(),
          UUID.randomUUID().toString(),
          clipData.getItemAt(it).uri,
          null
        )
        updatedList.add(newItem)
      }
      _pictureList.postValue(updatedList)
    }
  }

  fun deletePicture(item: RegisterEstatePicture) {
    //TODO : delete selected photo
    Log.d("register", "delete! $item")
  }

  class PictureListFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
      if (modelClass.isAssignableFrom(RegisterPictureListViewModel::class.java)) {
        @Suppress("UNCHECKED_CAST")
        return RegisterPictureListViewModel() as T
      }
      throw IllegalArgumentException("Unknown ViewModel class")
    }
  }
}