package com.idiot.data.repository

import androidx.annotation.WorkerThread
import com.idiot.model.TokenResponse

interface TokenRepository {

  @WorkerThread
  suspend fun requestToken(
    accessToken: String
  ): TokenResponse?

}