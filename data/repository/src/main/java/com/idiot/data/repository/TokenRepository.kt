package com.idiot.data.repository

import androidx.annotation.WorkerThread
import com.idiot.model.TokenResponse
import org.json.JSONObject

interface TokenRepository {

  @WorkerThread
  suspend fun requestToken(
    provider: String,
    code: String
  ): TokenResponse?

}