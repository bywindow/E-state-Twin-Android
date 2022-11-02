package com.idiot.data.repository

import androidx.annotation.WorkerThread
import com.idiot.data.api.EstateClient
import com.idiot.model.RecommendedEstate
import timber.log.Timber
import javax.inject.Inject

class RecommendedEstateRepositoryImpl @Inject constructor(
  private val estateClient: EstateClient
): RecommendedEstateRepository {

  @WorkerThread
  override suspend fun requestRecommendedEstate(accessToken: String): List<RecommendedEstate>? {
    val response = estateClient.requestRecommendedEstate(accessToken = "Bearer $accessToken")
    Timber.d("main response: $response")
    return if (response.isSuccessful) response.body() as List<RecommendedEstate> else null
  }

}