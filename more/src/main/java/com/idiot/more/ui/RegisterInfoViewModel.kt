package com.idiot.more.ui

import android.app.Application
import android.net.Uri
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.idiot.data.repository.EstateFloorPlanUploadRepository
import com.idiot.data.repository.EstateImageS3UploadRepository
import com.idiot.model.AWSUploadResponse
import com.idiot.model.HouseOption
import com.idiot.model.RegisterEstatePicture
import com.idiot.data.repository.samples.optionSample
import com.idiot.model.DetailAsset
import com.idiot.more.util.FileUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import java.io.File
import javax.inject.Inject
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.MutableMap
import kotlin.collections.associateBy
import kotlin.collections.emptyList
import kotlin.collections.flatten
import kotlin.collections.forEach
import kotlin.collections.last
import kotlin.collections.listOf
import kotlin.collections.mapOf
import kotlin.collections.mutableListOf
import kotlin.collections.set
import kotlin.collections.toMutableList
import kotlin.collections.toMutableMap
import kotlin.random.Random

@HiltViewModel
class RegisterInfoViewModel @Inject constructor(
  application: Application,
  private val estateImageS3UploadRepository: EstateImageS3UploadRepository,
  private val estateFloorPlanUploadRepository: EstateFloorPlanUploadRepository
) : AndroidViewModel(application) {

  private val _pictureList = MutableLiveData<List<RegisterEstatePicture>>()
  val pictureList: LiveData<List<RegisterEstatePicture>>
    get() = _pictureList
  private val _estatePictureUri = MutableStateFlow(emptyList<AWSUploadResponse>())
  val estatePictureUri: StateFlow<List<AWSUploadResponse>> = _estatePictureUri

  private val _estateFloorPlan = MutableStateFlow<AWSUploadResponse?>(null)
  val estateFloorPlan: StateFlow<AWSUploadResponse?> = _estateFloorPlan

  private val _optionList = MutableLiveData<Map<Int, HouseOption>>(mapOf())
  val optionList: LiveData<Map<Int,HouseOption>> = _optionList

  private val _assetList = MutableStateFlow<List<DetailAsset>>(emptyList())
  val assetList: StateFlow<List<DetailAsset>> = _assetList

  private val _estateType = MutableStateFlow(0)
  val estateType: StateFlow<Int> = _estateType

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

  private val _buildingName = MutableStateFlow("")
  val buildingName: StateFlow<String> = _buildingName

  private val _totalBuildingFloor = MutableStateFlow(0)
  val totalBuildingFloor: StateFlow<Int> = _totalBuildingFloor

  private val _curBuildingFloor = MutableStateFlow(0)
  val curBuildingFloor: StateFlow<Int> = _curBuildingFloor

  private val _netArea = MutableStateFlow(0.0f)
  val netArea: StateFlow<Float> = _netArea

  private val _area = MutableStateFlow(0.0f)
  val area: StateFlow<Float> = _area

  // 가격 정보
  private val _deposit = MutableStateFlow(0)
  val deposit: StateFlow<Int> = _deposit

  private val _monthly = MutableStateFlow(0)
  val monthly: StateFlow<Int> = _monthly

  private val _managementFee = MutableStateFlow(0)
  val managementFee: StateFlow<Int> = _managementFee

  private val _managementFeeIncluding = MutableStateFlow(mapOf(Pair(0, false), Pair(1, false), Pair(2, false), Pair(3, false)))
  val managementFeeIncluding: StateFlow<Map<Int, Boolean>> = _managementFeeIncluding

  private val _enableParking = MutableStateFlow(false)
  val enableParking: StateFlow<Boolean> = _enableParking

  private val _parkingFee = MutableStateFlow(0)
  val parkingFee: StateFlow<Int> = _parkingFee

  private val _address = MutableStateFlow("")
  val address: StateFlow<String> = _address

  init {
      _optionList.value = optionSample().associateBy { it.id }
  }

  fun insertPicture(images: List<Uri>) {
    val context = getApplication<Application>().applicationContext
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
        val file: File = FileUtil.convertUriToFile(context, it)
        Timber.d("File Path VM: $file")
        imageFormList.add(file)
      }
      _pictureList.postValue(updatedList)
      Timber.d("s3 new list: $updatedList")
      val response = estateImageS3UploadRepository.requestImageUri(imageFormList)
      Timber.d("s3 image: $response")
      _estatePictureUri.value = listOf(_estatePictureUri.value, response).flatten()
    }
  }

  fun deletePicture(item: RegisterEstatePicture) {
    //TODO : delete selected photo
    Log.d("register", "delete! $item")
  }

  fun insertFloorPlan(estateId: Int, image: Uri) {
    val context = getApplication<Application>().applicationContext
    viewModelScope.launch {
      val file: File = FileUtil.convertUriToFile(context, image)
      val response = estateFloorPlanUploadRepository.requestEstateFloorPlan(estateId, file)
      Timber.d("aws floor plan response: $response")
      _estateFloorPlan.value = response
    }
  }

  fun changeOptionStatus(item: HouseOption) {
    val currentStatus = _optionList.value
    val updatedStatus = currentStatus!!.toMutableMap()
    updatedStatus[item.id]?.hasOption = !item.hasOption
    _optionList.value = updatedStatus
  }

  fun changeEstateType(position: Int) {
    if (position == estateType.value) return
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

  fun changeBuildingName(name: String) {
    _buildingName.value = name
  }

  fun changeTotalBuildingFloor(floor: Int) {
    _totalBuildingFloor.value = floor
  }

  fun changeCurBuildingFloor(floor: Int) {
    _curBuildingFloor.value = floor
  }

  fun changeNetArea(size: Float) {
    _netArea.value = size
  }

  fun changeArea(size: Float) {
    _area.value = size
  }

  fun changeDeposit(price: Int) {
    _deposit.value = price
  }

  fun changeMonthly(price: Int) {
    _monthly.value = price
  }

  fun changeManagementFee(price: Int) {
    _managementFee.value = price
  }

  fun changeParkingFee(price: Int) {
    _parkingFee.value = price
  }

  fun changeManagementIncluding(key: Int) {
    val temp: MutableMap<Int, Boolean> = _managementFeeIncluding.value.toMutableMap()
    temp[key] = !temp[key]!!
    _managementFeeIncluding.value = temp
  }

  fun changeAddress(data: String) {
    _address.value = data
  }

  fun changeArChecklist(data: List<Pair<Int, String>>) {
    val temp = _optionList.value!!.toMutableMap()
    data.forEach {
      temp[it.first]?.anchorId = it.second
    }
    _optionList.postValue(temp)
    Timber.d("ASSET OPTION LIST: ${optionList.value}")
  }
}