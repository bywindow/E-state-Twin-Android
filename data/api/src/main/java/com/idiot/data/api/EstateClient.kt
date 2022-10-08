package com.idiot.data.api

import com.idiot.model.TokenResponse
import retrofit2.Response
import javax.inject.Inject

class EstateClient @Inject constructor(
  private val estateService: EstateService
) {

  suspend fun requestToken(
    accessToken: String
  ): Response<TokenResponse> = estateService.requestToken(accessToken = accessToken)

}