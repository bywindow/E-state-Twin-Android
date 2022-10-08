package com.idiot.data.repository

import androidx.annotation.WorkerThread
import com.idiot.data.api.EstateClient
import com.idiot.model.TokenResponse
import timber.log.Timber
import javax.inject.Inject

class TokenRepositoryImpl @Inject constructor(
  private val estateClient: EstateClient
): TokenRepository {

  @WorkerThread
  override suspend fun requestToken(provider: String, code: String) : TokenResponse? {
    Timber.d("TAG: Request")
    val response = estateClient.requestToken(provider = provider, body = code)
    Timber.d("TAG: $response")
    return if (response.isSuccessful) response.body() as TokenResponse else null
  }
}