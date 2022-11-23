package com.idiot.data.repository

import androidx.annotation.WorkerThread
import com.idiot.data.api.EstateClient
import com.idiot.model.AssetIncludingChecklist
import com.idiot.model.DetailEstate
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

class GetEstateDetailRepositoryImpl @Inject constructor(
  private val estateClient: EstateClient,
  private val userPreferenceRepository: UserPreferenceRepository
): GetEstateDetailRepository {

  @WorkerThread
  override suspend fun requestGetDetailEstate(
    estateId: Long
  ): DetailEstate? {
    val token = userPreferenceRepository.getAccessToken().getOrNull().orEmpty()
    val response = estateClient.requestGetDetailEstate(
      accessToken = "Bearer $token",
      estateId = estateId
    )
    Timber.d("DETAIL REPO : $response")
    return if (response.isSuccessful) response.body() as DetailEstate else null
  }

  @WorkerThread
  override suspend fun requestGetAssets(assetId: Long): AssetIncludingChecklist? {
    val token = userPreferenceRepository.getAccessToken().getOrNull().orEmpty()
    val response = estateClient.requestGetAssets(
      accessToken = "Bearer $token",
      assetId = assetId
    )
    Timber.d("ASSET RESPONSE : $response")
    return if (response.isSuccessful) response.body() as AssetIncludingChecklist else null
  }
}