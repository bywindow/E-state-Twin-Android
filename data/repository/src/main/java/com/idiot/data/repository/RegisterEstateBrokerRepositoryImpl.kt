package com.idiot.data.repository

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.idiot.data.api.EstateClient
import com.idiot.model.RegisterEstateBroker
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import javax.inject.Inject

class RegisterEstateBrokerRepositoryImpl @Inject constructor(
  private val estateClient: EstateClient
): RegisterEstateBrokerRepository {

  override suspend fun requestPostEstateBroker(
    accessToken: String,
    data: RegisterEstateBroker
  ): JSONObject {
    val gson = Gson()
    val json = gson.toJson(data)
    val response = estateClient.requestPostEstateBroker(
      accessToken = "Bearer $accessToken",
      body = json.toRequestBody()
    )
    return if (response.isSuccessful) response.body() as JSONObject else JSONObject("")
  }

}