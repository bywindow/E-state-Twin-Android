package com.idiot.data.repository

import com.idiot.data.api.EstateClient
import com.idiot.model.RegisterEstateBroker
import org.json.JSONObject
import javax.inject.Inject

class RegisterEstateBrokerRepositoryImpl @Inject constructor(
  private val estateClient: EstateClient
): RegisterEstateBrokerRepository {

  override suspend fun requestPostEstateBroker(
    accessToken: String,
    body: RegisterEstateBroker
  ): JSONObject {
    TODO("Not yet implemented")
  }

}