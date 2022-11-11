package com.idiot.data.repository

import androidx.annotation.WorkerThread
import com.google.gson.Gson
import com.idiot.data.api.EstateClient
import com.idiot.model.RegisterEstateOwner
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import timber.log.Timber
import javax.inject.Inject

class RegisterEstateOwnerRepositoryImpl @Inject constructor(
  private val estateClient: EstateClient
) : RegisterEstateOwnerRepository{

  @WorkerThread
  override suspend fun requestEstateOwner(accessToken: String, data: RegisterEstateOwner) : String {
    val gson = Gson()
    val json = gson.toJson(data)
    val token = "Bearer $accessToken"
    val response = estateClient.requestPostEstateOwner(token, json.toRequestBody())
    Timber.d("RES : $response")
    return if (response.isSuccessful) "OK" else "NO"
  }
}