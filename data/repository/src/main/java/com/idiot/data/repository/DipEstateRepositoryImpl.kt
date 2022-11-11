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

  @WorkerThread
  override suspend fun requestEstateInquiry(estateId: Long): RegisterEstateBrokerResponse? {
    val token = userPreferenceRepository.getAccessToken().getOrNull().orEmpty()
    val response = estateClient.requestEstateInquiry(accessToken = "Bearer $token", estateId = estateId)
    Timber.d("INQUIRY : ${response.body()}")
    return if (response.isSuccessful) response.body() as RegisterEstateBrokerResponse else null
  }

  @WorkerThread
  override suspend fun requestEstateContract(estateId: Long): RegisterEstateBrokerResponse? {
    val token = userPreferenceRepository.getAccessToken().getOrNull().orEmpty()
    val response = estateClient.requestEstateContract(accessToken = "Bearer $token", estateId = estateId)
    Timber.d("CONTRACT : ${response.body()}")
    return if (response.isSuccessful) response.body() as RegisterEstateBrokerResponse else null
  }
}