package com.idiot.more.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idiot.data.repository.RegisterEstateOwnerRepository
import com.idiot.data.repository.UserPreferenceRepository
import com.idiot.model.RegisterEstateOwner
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class RequestOwnerToBrokerViewModel @Inject constructor(
  private val userPreferenceRepository: UserPreferenceRepository,
  private val registerEstateOwnerRepository: RegisterEstateOwnerRepository
) : ViewModel() {

  private val _address = MutableStateFlow<List<String>>(emptyList()) //city, borough, road, main, sub
  val address: StateFlow<List<String>> = _address

  private val _buildingName = MutableStateFlow("")
  val buildingName : StateFlow<String> =_buildingName

  private val _mainNumber = MutableStateFlow(0)
  val mainNumber: StateFlow<Int> = _mainNumber

  private val _subNumber = MutableStateFlow(0)
  val subNumber: StateFlow<Int> = _subNumber

  fun changeAddress(data: String) {
    Timber.d(data)
    val splitData = data.split(" ").toMutableList()
    splitData[0] += "특별시"
    _address.value = listOf(splitData.take(3), splitData[3].split("-")).flatten()
    Timber.d(address.value.toString())
  }

  fun changeBuildingName(s: CharSequence, start: Int, before: Int, count: Int) {
    _buildingName.value = "$s"
    Timber.d(buildingName.value.toString())
  }

  fun changeMainNumber(s: CharSequence, start: Int, before: Int, count: Int) {
    _mainNumber.value = s.toString().toInt()
  }

  fun changeSubNumber(s: CharSequence, start: Int, before: Int, count: Int) {
    _subNumber.value = s.toString().toInt()
  }

  suspend fun requestPostEstateOwner() {
    viewModelScope.launch {
      val data = RegisterEstateOwner(
        city = address.value[0],
        borough = address.value[1],
        roadName = address.value[2],
        mainBuildingNumber = mainNumber.value,
        subBuildingNumber = subNumber.value,
        buildingName = buildingName.value
      )
      val token = userPreferenceRepository.getAccessToken().getOrNull().orEmpty()
      val response = registerEstateOwnerRepository.requestEstateOwner(token, data)
      Timber.d("$response")
    }
  }
}