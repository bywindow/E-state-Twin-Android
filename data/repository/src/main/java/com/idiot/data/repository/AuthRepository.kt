package com.idiot.data.repository

import android.app.Application
import android.util.Log
import com.idiot.data.api_builder.AuthResponse
import com.idiot.model.AuthCodeResponse

class AuthRepository(application: Application) {

  suspend fun load(provider: String) : AuthCodeResponse {
    val response = AuthResponse.getAuthCodeService.postLoginRequest(provider)
    Log.d("TAG", "$response")
    return if (response.isSuccessful) response.body() as AuthCodeResponse else AuthCodeResponse(accessToken = "", refreshToken = "")
  }

  companion object {
    private var instance : AuthRepository? = null

    fun getInstance(application: Application): AuthRepository? {
      if (instance == null) instance = AuthRepository(application)
      return instance
    }
  }
}