package com.idiot.data.repository

import androidx.annotation.WorkerThread
import com.idiot.data.api.EstateClient
import com.idiot.model.RegisterEstateBrokerResponse
import javax.inject.Inject

class RegisterEstateConfirmRepositoryImpl @Inject constructor(
  private val estateClient: EstateClient,
  private val userPreferenceRepository: UserPreferenceRepository
) : RegisterEstateConfirmRepository {

  @WorkerThread
  override suspend fun requestEstateConfirm(estateId: Long): RegisterEstateBrokerResponse? {
    val token = userPreferenceRepository.getAccessToken().getOrNull().orEmpty()
    val response = estateClient.requestEstateConfirm(
      accessToken = "Bearer $token",
      estateId = estateId
    )
    return if (response.isSuccessful) response.body() as RegisterEstateBrokerResponse else null
  }
}