package com.idiot.data.api

import com.idiot.model.TokenResponse
import com.idiot.model.users.UserSignUpResponse
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject

class EstateClient @Inject constructor(
  private val estateService: EstateService
) {
  suspend fun requestToken(
    provider: String,
    body: String
  ): Response<TokenResponse> = estateService.requestToken(
    provider = provider,
    body = body
  )

  suspend fun requestSignUp(
    accessToken: String,
    body: RequestBody
  ): Response<UserSignUpResponse> = estateService.requestSignUp(
    accessToken = accessToken,
    body = body
  )

}