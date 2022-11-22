package com.idiot.data.repository

import androidx.annotation.WorkerThread
import com.google.gson.Gson
import com.idiot.data.api.EstateClient
import com.idiot.model.EstateSearchResponse
import com.idiot.model.users.SearchByBorough
import okhttp3.RequestBody.Companion.toRequestBody
import timber.log.Timber
import javax.inject.Inject

class EstateSearchRepositoryImpl @Inject constructor(
  private val estateClient: EstateClient,
  private val userPreferenceRepository: UserPreferenceRepository
) : EstateSearchRepository {

  @WorkerThread
  override suspend fun requestEstateSearchList(data: SearchByBorough): List<EstateSearchResponse> {
    val token = userPreferenceRepository.getAccessToken().getOrNull().orEmpty()
    val gson = Gson()
    val json = gson.toJson(data)
    Timber.d("json : $json")
    val response = estateClient.requestEstateSearchList("Bearer $token", json.toRequestBody())
    Timber.d("response : $response")
    return if (response.isSuccessful) response.body() as List<EstateSearchResponse> else emptyList()
  }

}