package com.idiot.more.ui

import androidx.lifecycle.ViewModel
import com.idiot.data.repository.MyPageRepository
import com.idiot.data.repository.UserPreferenceRepository
import com.idiot.model.users.MyPageResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MoreViewModel @Inject constructor(
  private val myPageRepository: MyPageRepository,
  private val userPreferenceRepository: UserPreferenceRepository
) : ViewModel() {

  private val _accessToken: MutableStateFlow<String> = MutableStateFlow("")

  private val _userInfo = MutableStateFlow(MyPageResponse(0, "", emptyList(), "", false))
  val userInfo: StateFlow<MyPageResponse> = _userInfo

  fun fetchUserInfo() = flow {
    val tokenResult = userPreferenceRepository.getAccessToken()
    val accessToken = tokenResult.getOrNull().orEmpty()
    _accessToken.value = accessToken
    val result = myPageRepository.requestMyPage(_accessToken.value)
    if (result != null) {
      _userInfo.value = result
    }
    Timber.d("my page response: $result")
    emit(MoreEvent.UserInfoFetchSuccess)
  }
}

sealed class MoreEvent {
  object UserInfoFetchSuccess : MoreEvent()
}