package com.idiot.data.repository

import androidx.annotation.WorkerThread
import com.idiot.data.api.EstateClient
import com.idiot.model.AssetIncludingChecklist
import com.idiot.model.TenantModeResponse
import timber.log.Timber
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
      Timber.d("$response")
      return if (response.isSuccessful) response.body() as TenantModeResponse else null
    } catch (e: Exception) {
      e.printStackTrace()
    }
    return null
  }

  @WorkerThread
  override suspend fun requestGetTenantAssetList(category: String): List<AssetIncludingChecklist> {
    val token = userPreferenceRepository.getAccessToken().getOrNull().orEmpty()
    val response = estateClient.requestGetTenantAssetList(accessToken = "Bearer $token", category = category)
    Timber.d("tenant asset list res : $response")
    return if (response.isSuccessful) response.body() as List<AssetIncludingChecklist> else emptyList()
  }
}