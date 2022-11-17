package com.idiot.data.repository

import androidx.annotation.WorkerThread
import com.idiot.data.api.EstateClient
import com.idiot.model.OwnerModeResponse
import javax.inject.Inject

class OwnerModeRepositoryImpl @Inject constructor(
  private val estateClient: EstateClient,
  private val userPreferenceRepository: UserPreferenceRepository
) : OwnerModeRepository {

  @WorkerThread
  override suspend fun requestOwnerMode(accessToken: String): List<OwnerModeResponse> {

    return try {
      val token = userPreferenceRepository.getAccessToken().getOrNull().orEmpty()
      val response = estateClient.requestGetOwnerMode("Bearer $token")
      if (response.isSuccessful) response.body() as List<OwnerModeResponse> else emptyList()
    } catch (e: Exception) {
      e.printStackTrace()
      emptyList()
    }
  }

}