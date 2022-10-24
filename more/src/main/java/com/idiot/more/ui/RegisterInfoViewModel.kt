package com.idiot.more.ui

import android.app.Application
import android.net.Uri
import android.util.Log
import androidx.lifecycle.*
import com.idiot.data.repository.EstateImageS3UploadRepository
import com.idiot.data.repository.samples.optionSample
import com.idiot.model.HouseOption
import com.idiot.model.RegisterEstatePicture
import com.idiot.more.util.FileUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import java.io.File
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class RegisterInfoViewModel @Inject constructor(
  application: Application,
  private val estateImageS3UploadRepository: EstateImageS3UploadRepository
) : AndroidViewModel(application) {

  private val _pictureList = MutableLiveData<List<RegisterEstatePicture>>()
  val pictureList: LiveData<List<RegisterEstatePicture>>
    get() = _pictureList

  private val _optionList = MutableLiveData<Map<Int, HouseOption>>(mapOf())
  val optionList: LiveData<Map<Int,HouseOption>> = _optionList

  private val _estateType = MutableStateFlow(0)
  val estatetype: StateFlow<Int> = _estateType

  private val _heatType = MutableStateFlow(0)
  val heatType: StateFlow<Int> = _heatType

  private val _roomType = MutableStateFlow(0)
  val roomType: StateFlow<Int> = _roomType

  private val _hasElevator = MutableStateFlow(0)
  val hasElevator: StateFlow<Int> = _hasElevator

  private val _hasDuplex = MutableStateFlow(0)
  val hasDuplex: StateFlow<Int> = _hasDuplex

  private val _hasVeranda = MutableStateFlow(0)
  val hasVeranda: StateFlow<Int> = _hasVeranda

  private val _ableShort = MutableStateFlow(0)
  val ableShort: StateFlow<Int> = _ableShort

  private val _availableDate = MutableStateFlow(emptyList<Int>())
  val availableDate: StateFlow<List<Int>> = _availableDate

  init {
      _optionList.value = optionSample().associateBy { it.id }
  }

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
      val response = estateImageS3UploadRepository.requestImageUri(imageFormList)
      Timber.d("s3 image: $response")
    }
  }

  fun deletePicture(item: RegisterEstatePicture) {
    //TODO : delete selected photo
    Log.d("register", "delete! $item")
  }

  fun changeOptionStatus(item: HouseOption) {
    val currentStatus = _optionList.value
    val updatedStatus = currentStatus!!.toMutableMap()
    updatedStatus[item.id]?.hasOption = !item.hasOption
    _optionList.value = updatedStatus
  }

  fun changeEstateType(position: Int) {
    if (position == estatetype.value) return
    _estateType.value = position
  }

  fun changeHeatType(position: Int) {
    if (position == heatType.value) return
    _heatType.value = position
  }

  fun elevatorButtonClicked(position: Boolean) {
    if (position) {
      _hasElevator.value = 1
    } else {
      _hasElevator.value = 2
    }
  }

  fun duplexButtonClicked(position: Boolean) {
    if (position) {
      _hasDuplex.value = 1
    } else {
      _hasDuplex.value = 2
    }
  }

  fun changeRoomType(position: Int) {
    if (position == roomType.value) return
    _roomType.value = position
  }

  fun verandaButtonClicked(position: Boolean) {
    if (position) {
      _hasVeranda.value = 1
    } else {
      _hasVeranda.value = 2
    }
  }

  fun shortAbleButtonClicked(position: Boolean) {
    if (position) {
      _ableShort.value = 1
    } else {
      _ableShort.value = 2
    }
  }

  fun changeAvailableDate(year: Int, month: Int, day: Int) {
    val temp = listOf(year, month, day)
    _availableDate.value = temp
  }

}