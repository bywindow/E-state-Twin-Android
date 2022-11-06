package com.idiot.data.repository

import com.google.gson.Gson
import com.idiot.data.api.EstateClient
import com.idiot.model.RegisterEstateBroker
import com.idiot.model.RegisterEstateBrokerResponse
import okhttp3.RequestBody.Companion.toRequestBody
import javax.inject.Inject

class RegisterEstateBrokerRepositoryImpl @Inject constructor(
  private val estateClient: EstateClient
): RegisterEstateBrokerRepository {

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
    return if (response.isSuccessful) response.body() as RegisterEstateBrokerResponse else null
  }

}