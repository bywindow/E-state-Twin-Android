package com.idiot.data.repository

import androidx.annotation.WorkerThread
import com.idiot.data.api.EstateClient
import timber.log.Timber
import javax.inject.Inject

class UserDeleteRepositoryImpl @Inject constructor(
  private val estateClient: EstateClient
): UserDeleteRepository {

  @WorkerThread
  override suspend fun requestDeleteUser(accessToken: String): Int {
    val response = estateClient.requestDeleteUser(accessToken)
    Timber.d("user delete response : $response")
    return if (response.body() != null) response.body() as Int else -1
  }
}