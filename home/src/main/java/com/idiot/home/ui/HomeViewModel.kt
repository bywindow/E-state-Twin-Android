package com.idiot.home.ui

import androidx.lifecycle.ViewModel
import com.idiot.data.repository.RecommendedEstateRepository
import com.idiot.data.repository.UserPreferenceRepository
import com.idiot.model.RecommendedEstate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
  private val recommendedEstateRepository: RecommendedEstateRepository,
  private val userPreferenceRepository: UserPreferenceRepository,
) : ViewModel() {
  private val _accessToken: MutableStateFlow<String> = MutableStateFlow("")

  private val _recommendedEstates: MutableStateFlow<List<RecommendedEstate>> =
    MutableStateFlow(emptyList())
  val recommendedEstates: StateFlow<List<RecommendedEstate>> = _recommendedEstates

  init {

    Timber.d("homeviewmodel")

  }

  fun fetchRecommendedEstate() = flow {
    val tokenResult = userPreferenceRepository.getAccessToken()
    val accessToken = tokenResult.getOrNull().orEmpty()
    _accessToken.value = accessToken
    val result = recommendedEstateRepository.requestRecommendedEstate(_accessToken.value)
    if (result != null) {
      _recommendedEstates.value = result
    }
    Timber.d("추천매물 response: $result")
    emit(HomeEvent.EstateFetchSuccess)
  }

  fun estateItemButtonClicked() {

  }
}

sealed class HomeEvent {
  class CachedTokenFetchSuccess(val accessToken: String) : HomeEvent()
  object EstateFetchSuccess : HomeEvent()
}