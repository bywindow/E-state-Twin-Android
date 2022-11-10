package com.idiot.data.repository

import androidx.annotation.WorkerThread

interface UserPreferenceRepository {

  @WorkerThread
  suspend fun setToken(
    accessToken: String,
    refreshToken: String
  )

  @WorkerThread
  suspend fun getAccessToken(): Result<String>

  @WorkerThread
  suspend fun setUserRole(
    role: String,
  )

  @WorkerThread
  suspend fun getUserRole(): Result<String>

}