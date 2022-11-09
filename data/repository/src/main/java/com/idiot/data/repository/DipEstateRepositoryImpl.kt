package com.idiot.data.repository

import androidx.annotation.WorkerThread
import com.idiot.data.api.EstateClient
import com.idiot.model.RegisterEstateBrokerResponse
import timber.log.Timber
import javax.inject.Inject

class DipEstateRepositoryImpl @Inject constructor(
  private val estateClient: EstateClient,
  private val userPreferenceRepository: UserPreferenceRepository
) : DipEstateRepository {

  @WorkerThread
  override suspend fun requestEstateDip(estateId: Long): RegisterEstateBrokerResponse? {
    val token = userPreferenceRepository.getAccessToken().getOrNull().orEmpty()
    val response = estateClient.requestEstateDip(accessToken = "Bearer $token", estateId = estateId)
    Timber.d("DIP : ${response.body()?.id}")
    return if (response.isSuccessful) response.body() as RegisterEstateBrokerResponse else null
  }
}