package com.idiot.feature.login.ui.main

import android.app.Application
import androidx.lifecycle.*
import com.idiot.data.repository.AuthRepository
import com.idiot.model.AuthCodeResponse
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: AuthRepository) : ViewModel() {
  private val _authTokens = MutableLiveData<AuthCodeResponse>()
  val authTokens: LiveData<AuthCodeResponse>
    get() = _authTokens

  fun getUserToken(code: String) {
    viewModelScope.launch {
      val tokens = repository.load(code)
      _authTokens.postValue(tokens)
    }
  }

  @Suppress("UNCHECKED_CAST")
  class AuthTokenFactory(private val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
      return LoginViewModel(AuthRepository.getInstance(application)!!) as T
    }
  }
}