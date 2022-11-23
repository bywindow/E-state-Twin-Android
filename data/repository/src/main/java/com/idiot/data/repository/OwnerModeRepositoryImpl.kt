package com.idiot.data.repository

import androidx.annotation.WorkerThread
import com.idiot.data.api.EstateClient
import com.idiot.model.AssetIncludingChecklist
import com.idiot.model.OwnerModeResponse
import timber.log.Timber
import javax.inject.Inject

class OwnerModeRepositoryImpl @Inject constructor(
  private val estateClient: EstateClient,
  private val userPreferenceRepository: UserPreferenceRepository
) : OwnerModeRepository {

  @WorkerThread
  override suspend fun requestOwnerMode(): List<OwnerModeResponse> {

    return try {
      val token = userPreferenceRepository.getAccessToken().getOrNull().orEmpty()
      val response = estateClient.requestGetOwnerMode("Bearer $token")
      Timber.d("owner mode : $response")
      if (response.isSuccessful) response.body() as List<OwnerModeResponse> else emptyList()
    } catch (e: Exception) {
      e.printStackTrace()
      emptyList()
    }

  }

  @WorkerThread
  override suspend fun requestOwnerAssetList(estateId: Long): List<AssetIncludingChecklist> {
    val token = userPreferenceRepository.getAccessToken().getOrNull().orEmpty()
    val response = estateClient.requestGetOwnerAssetList(
      accessToken = "Bearer $token",
      estateId = estateId
    )
    return if (response.isSuccessful) response.body() as List<AssetIncludingChecklist> else emptyList()
  }

}