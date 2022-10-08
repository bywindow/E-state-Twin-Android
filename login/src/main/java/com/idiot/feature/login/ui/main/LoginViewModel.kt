package com.idiot.feature.login.ui.main

import androidx.lifecycle.ViewModel
import com.idiot.data.repository.TokenRepository
import com.idiot.model.TokenResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
  private val repository: TokenRepository
) : ViewModel() {

  private val _token: MutableStateFlow<TokenResponse?> = MutableStateFlow(null)
  val token: StateFlow<TokenResponse?> = _token

  suspend fun requestToken(accessToken: String) {
    val tokenResponse = repository.requestToken(accessToken)
  }
}