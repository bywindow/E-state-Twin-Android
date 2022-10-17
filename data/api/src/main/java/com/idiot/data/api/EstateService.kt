package com.idiot.data.api

import com.idiot.model.RecommendedEstate
import com.idiot.model.TokenResponse
import com.idiot.model.users.UserSignUpResponse
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface EstateService {

  @POST("user/login/oauth/{provider}")
  suspend fun requestToken(
    @Path("provider") provider: String = "kakao",
    @Body body: String
  ): Response<TokenResponse>

  @POST("user/signup")
  suspend fun requestSignUp(
    @Header("Content-Type") contentType: String = "application/json",
    @Header("X-AUTH-TOKEN") accessToken: String,
    @Body body: RequestBody
  ): Response<UserSignUpResponse>

  @GET("estate/main")
  suspend fun requestRecommendedEstate(
    @Header("X-AUTH-TOKEN") accessToken: String
  ): Response<List<RecommendedEstate>>

}