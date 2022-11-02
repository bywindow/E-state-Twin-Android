package com.idiot.data.api

import com.idiot.model.EstateListBrokerResponse
import com.idiot.model.RecommendedEstate
import com.idiot.model.TokenResponse
import com.idiot.model.users.MyPageResponse
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

  suspend fun requestRecommendedEstate(
    accessToken: String
  ): Response<List<RecommendedEstate>> = estateService.requestRecommendedEstate(
    accessToken = accessToken
  )

  suspend fun requestMyPage(
    accessToken: String
  ): Response<MyPageResponse> = estateService.requestMyPage(
    accessToken = accessToken
  )

  suspend fun requestDeleteUser(
    accessToken: String
  ): Response<Int> = estateService.requestDeleteUser(
    accessToken = accessToken
  )

  suspend fun requestPostEstateOwner(
    accessToken: String,
    body: RequestBody
  ): Response<String> = estateService.requestPostEstateOwner(
    accessToken = accessToken,
    body = body
  )

  suspend fun requestGetEstateListBroker(
    accessToken: String,
    state: String
  ): Response<List<EstateListBrokerResponse>> = estateService.requestGetEstateListBroker(
    accessToken = accessToken,
    state = state
  )

  suspend fun requestPostEstateBroker(
    accessToken: String,
    body: RequestBody
  ): Response<String> = estateService.requestPostEstateBroker(
    accessToken = accessToken,
    body = body
  )
}