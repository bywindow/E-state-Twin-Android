package com.idiot.data.repository

import androidx.annotation.WorkerThread
import com.idiot.data.api.EstateClient
import com.idiot.model.TokenResponse
import javax.inject.Inject

class TokenRepositoryImpl @Inject constructor(
  private val estateClient: EstateClient
): TokenRepository {

  @WorkerThread
  override suspend fun requestToken(accessToken: String) : TokenResponse? {
    val response = estateClient.requestToken(accessToken = accessToken)
    return if (response.isSuccessful) response.body() as TokenResponse else null
  }
}