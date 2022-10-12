package com.idiot.feature.login.ui.main

import androidx.lifecycle.ViewModel
import com.idiot.data.repository.TokenRepository
import com.idiot.data.repository.UserPreferenceRepository
import com.idiot.model.TokenResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
  private val repository: TokenRepository,
  private val userPreferenceRepository: UserPreferenceRepository
) : ViewModel() {

  private val _token: MutableStateFlow<TokenResponse?> = MutableStateFlow(null)
  val token: StateFlow<TokenResponse?> = _token

  init {
      Timber.d("TAG: LoginViewModel")
  }

  suspend fun requestToken(provider: String, code: String) {
    val tokenResponse = repository.requestToken(provider, code)
    _token.value = tokenResponse
  }

  fun cacheToken(
    accessToken: String,
    refreshToken: String
  ) = flow {
    userPreferenceRepository.setToken(accessToken, refreshToken)
    emit(LoginEvent.TokenCachedSuccess)
  }

  fun getToken() = flow {
    val result = userPreferenceRepository.getAccessToken()
    val accessToken = result.getOrNull().orEmpty()
    emit(LoginEvent.CachedTokenFetchSuccess(accessToken))
  }

}

sealed class LoginEvent {
  object TokenCachedSuccess : LoginEvent()
  class CachedTokenFetchSuccess(val accessToken: String) : LoginEvent()
}