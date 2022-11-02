package com.idiot.data.repository

import androidx.annotation.WorkerThread
import com.google.gson.Gson
import com.idiot.data.api.EstateClient
import com.idiot.model.users.UserSignUp
import com.idiot.model.users.UserSignUpResponse
import okhttp3.RequestBody.Companion.toRequestBody
import timber.log.Timber
import javax.inject.Inject

class UserSignUpRepositoryImpl @Inject constructor(
  private val estateClient: EstateClient
): UserSignUpRepository {

  @WorkerThread
  override suspend fun requestSignUp(accessToken: String, data: UserSignUp): UserSignUpResponse? {
    val gson = Gson()
    val json = gson.toJson(data)
    Timber.d("data: $json")
    val response = estateClient.requestSignUp(accessToken = "Bearer $accessToken", body = json.toRequestBody())
    Timber.d("signup response: $response")
    return if (response.isSuccessful) response.body() as UserSignUpResponse else null
  }
}