package com.idiot.feature.login.ui.main

import androidx.lifecycle.ViewModel
import com.idiot.data.repository.TokenRepository
import com.idiot.model.TokenResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
  private val repository: TokenRepository
) : ViewModel() {

  private val _token: MutableStateFlow<TokenResponse?> = MutableStateFlow(null)
  val token: StateFlow<TokenResponse?> = _token

  init {
      Timber.d("TAG: LoginViewModel")
  }

  suspend fun requestToken(provider: String, code: String) {
    val tokenResponse = repository.requestToken(provider, code)
    Timber.d("$tokenResponse")
  }
}