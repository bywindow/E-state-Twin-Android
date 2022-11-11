package com.idiot.data.repository

import androidx.annotation.WorkerThread
import com.google.gson.Gson
import com.idiot.data.api.EstateClient
import com.idiot.model.RegisterEstateBroker
import com.idiot.model.RegisterEstateBrokerResponse
import okhttp3.RequestBody.Companion.toRequestBody
import timber.log.Timber
import javax.inject.Inject

class RegisterEstateBrokerRepositoryImpl @Inject constructor(
  private val estateClient: EstateClient
): RegisterEstateBrokerRepository {

  @WorkerThread
  override suspend fun requestPostEstateBroker(
    accessToken: String,
    body: RegisterEstateBroker
  ): RegisterEstateBrokerResponse? {
    val gson = Gson()
    val json = gson.toJson(body)
    val response = estateClient.requestPostEstateBroker(
      accessToken = "Bearer $accessToken",
      body = json.toRequestBody()
    )
    Timber.d("매물 등록 api : $response")
    return if (response.isSuccessful) response.body() as RegisterEstateBrokerResponse else null
  }

}