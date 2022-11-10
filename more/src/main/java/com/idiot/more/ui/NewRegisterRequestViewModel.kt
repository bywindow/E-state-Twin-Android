package com.idiot.more.ui

import androidx.lifecycle.ViewModel
import com.idiot.data.repository.BrokerEstateListRepository
import com.idiot.data.repository.UserPreferenceRepository
import com.idiot.model.EstateListBrokerResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class NewRegisterRequestViewModel @Inject constructor(
  private val userPreferenceRepository: UserPreferenceRepository,
  private val brokerEstateListRepository: BrokerEstateListRepository
) : ViewModel() {

  private val _estateList = MutableStateFlow<List<EstateListBrokerResponse>>(emptyList())
  val estateList: StateFlow<List<EstateListBrokerResponse>> = _estateList

  fun getEstateList() = flow {
    val token = userPreferenceRepository.getAccessToken().getOrNull().orEmpty()
    val response = brokerEstateListRepository.requestGetEstateListBroker(token, "BROKER_BEFORE")
    if (response != null) {
      _estateList.value = response
    }
    Timber.d("${estateList.value}")
    emit(RegisterEvent.GetBrokerEstateList)
  }
}

sealed class RegisterEvent {
  object GetBrokerEstateList : RegisterEvent()
}