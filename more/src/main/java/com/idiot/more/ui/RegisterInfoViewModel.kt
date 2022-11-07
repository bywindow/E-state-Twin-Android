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
import com.idiot.data.repository.RegisterEstateBrokerRepository
import com.idiot.data.repository.UserPreferenceRepository
import com.idiot.data.repository.samples.optionSample
import com.idiot.model.*
import com.idiot.more.util.FileUtil
import com.idiot.more.util.MappingToEnumUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import java.io.File
import java.time.LocalDateTime
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
  private val userPreferenceRepository: UserPreferenceRepository,
  private val estateImageS3UploadRepository: EstateImageS3UploadRepository,
  private val estateFloorPlanUploadRepository: EstateFloorPlanUploadRepository,
  private val registerEstateBrokerRepository: RegisterEstateBrokerRepository,
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

  private val _availableDate = MutableStateFlow(emptyList<String>())
  val availableDate: StateFlow<List<String>> = _availableDate

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
      Timber.d(estateId.toString())
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

  fun changeAvailableDate(year: String, month: String, day: String) {
    val temp = listOf(year, month, day)
    _availableDate.value = temp
  }

  fun changeBuildingName(name: String) {
    _buildingName.value = name
    Timber.d(buildingName.value)
  }

  fun changeTotalBuildingFloor(floor: Int) {
    _totalBuildingFloor.value = floor
    Timber.d(totalBuildingFloor.value.toString())
  }

  fun changeCurBuildingFloor(floor: Int) {
    _curBuildingFloor.value = floor
    Timber.d(curBuildingFloor.value.toString())
  }

  fun changeNetArea(size: Float) {
    _netArea.value = size
    Timber.d(netArea.value.toString())
  }

  fun changeArea(size: Float) {
    _area.value = size
    Timber.d(area.value.toString())
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

  fun changeEnableParking(status: Boolean) {
    _enableParking.value = status
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

  fun changeArChecklist(data: List<DetailAsset>) {
    _assetList.value = data
  }

  fun requestPostEstate(id : Int) {
    var manageItem = ""
    managementFeeIncluding.value.entries.forEach {
      if (it.value) {
        manageItem += "${MappingToEnumUtil.maintenanceItemMapping(it.key)},"
      }
    }
    if (manageItem.isNotEmpty()) {
      manageItem = manageItem.substring(0, manageItem.length-1)
    }
    val house = DetailHouse(
      deposit = deposit.value,
      monthlyRent = monthly.value,
      sellingFee = 0,
      currentFloors = curBuildingFloor.value,
      totalFloors = totalBuildingFloor.value,
      shortTermRent = ableShort.value == 1,
      maintenanceFee = managementFee.value,
      itemsIncludedMaintenanceFee = manageItem,
      netRentableArea = netArea.value.toInt(),
      rentableArea = area.value.toInt(),
      parking = enableParking.value,
      parkingFee = parkingFee.value,
      moveInAvailableDate = "${availableDate.value[0]}-${availableDate.value[1]}-${availableDate.value[2]}",
      heatType = MappingToEnumUtil.heatTypeMapping(heatType.value),
      estateType = MappingToEnumUtil.estateTypeMapping(estateType.value),
      elevator = hasElevator.value == 1,
      duplex = hasDuplex.value == 1,
      structure = if (roomType.value == 1) "LOFT" else "SEPARATE_KITCHEN",
      veranda = hasVeranda.value == 1
    )
    val photoList : MutableList<String> = mutableListOf()
    estatePictureUri.value.forEach {
      photoList.add(it.file_url)
    }
    val data = RegisterEstateBroker(
      id = id,
      floorplan = "",
      transactionType = if (monthly.value == 0) "LEASE" else "MONTHLYRENT",
      arCam = "",
      house = house,
      estatePhotos = photoList,
      estateVideos = listOf(""),
      assets = assetList.value
    )
    viewModelScope.launch {
      val token = userPreferenceRepository.getAccessToken().getOrNull().orEmpty()
      val response = registerEstateBrokerRepository.requestPostEstateBroker(token, data)
      Timber.d("$response")
    }
  }
}