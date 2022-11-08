package com.idiot.data.repository

import androidx.annotation.WorkerThread
import com.idiot.data.api.EstateClient
import com.idiot.model.TenantModeResponse
import javax.inject.Inject

class TenantModeRepositoryImpl @Inject constructor(
  private val estateClient: EstateClient,
  private val userPreferenceRepository: UserPreferenceRepository
): TenantModeRepository {

  @WorkerThread
  override suspend fun requestGetTenantMode(): TenantModeResponse? {
    val token = userPreferenceRepository.getAccessToken().getOrNull().orEmpty()
    try {
      val response = estateClient.requestGetTenantMode("Bearer $token")
      return if (response.isSuccessful) response.body() as TenantModeResponse else null
    } catch (e: Exception) {
      e.printStackTrace()
    }
    return null
  }
}