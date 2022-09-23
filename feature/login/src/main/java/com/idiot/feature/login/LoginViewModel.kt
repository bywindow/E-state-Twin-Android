package com.idiot.feature.login

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.idiot.data.repository.AuthRepository
import com.idiot.model.AuthCodeResponse
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: AuthRepository) : ViewModel() {
  private val _authTokens = MutableLiveData<AuthCodeResponse>()
  val authTokens: LiveData<AuthCodeResponse>
    get() = _authTokens

  fun getAuthToken(code: String) {
    viewModelScope.launch {
      val tokens = repository.load(code)
      _authTokens.postValue(tokens)
    }
  }

  class AuthTokenFactory(private val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
      return LoginViewModel(AuthRepository.getInstance(application)!!) as T
    }
  }
}