package com.idiot.more.ui

import androidx.lifecycle.ViewModel
import com.idiot.data.repository.BrokerEstateListRepository
import com.idiot.data.repository.UserPreferenceRepository
import com.idiot.model.EstateListBrokerResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class RegisterForBrokerViewModel @Inject constructor(
  private val userPreferenceRepository: UserPreferenceRepository,
  private val brokerEstateListRepository: BrokerEstateListRepository
) : ViewModel() {
  private val _postingEstate = MutableStateFlow<List<EstateListBrokerResponse>>(emptyList())
  val postingEstate = _postingEstate.asStateFlow()

  fun getPostingEstateList() = flow {
    val token = userPreferenceRepository.getAccessToken().getOrNull().orEmpty()
    val response = brokerEstateListRepository.requestGetEstateListBroker(token, "POST_DOING")
    Timber.d("$response")
    if (response != null) {
      _postingEstate.value = response.reversed()
    }
    emit(RegisterEvent.GetBrokerEstateList)
  }
}