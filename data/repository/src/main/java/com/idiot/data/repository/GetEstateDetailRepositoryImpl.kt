package com.idiot.data.repository

import com.idiot.data.api.EstateClient
import com.idiot.model.DetailEstate
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

class GetEstateDetailRepositoryImpl @Inject constructor(
  private val estateClient: EstateClient,
  private val userPreferenceRepository: UserPreferenceRepository,
): GetEstateDetailRepository {

  override suspend fun requestGetDetailEstate(
    estateId: Int
  ): DetailEstate? {
    val token = userPreferenceRepository.getAccessToken().getOrNull().orEmpty()
    val response = estateClient.requestGetDetailEstate(
      accessToken = "Bearer $token",
      estateId = estateId
    )
    Timber.d("DETAIL REPO : $response")
    return if (response.isSuccessful) response.body() as DetailEstate else null
  }
}