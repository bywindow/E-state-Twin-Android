package com.idiot.data.repository

import androidx.annotation.WorkerThread
import com.idiot.data.api.EstateClient
import com.idiot.model.EstateListBrokerResponse
import javax.inject.Inject

class BrokerEstateListRepositoryImpl @Inject constructor(
  private val estateClient: EstateClient
): BrokerEstateListRepository {

  @WorkerThread
  override suspend fun requestGetEstateListBroker(
    accessToken: String,
    state: String
  ): List<EstateListBrokerResponse>? {
    val token = "Bearer $accessToken"
    val response = estateClient.requestGetEstateListBroker(token, state)
    return if (response.isSuccessful) response.body() as List<EstateListBrokerResponse> else null
  }

}