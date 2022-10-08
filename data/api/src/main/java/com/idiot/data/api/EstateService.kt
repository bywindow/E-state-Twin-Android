package com.idiot.data.api

import com.idiot.model.TokenResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Query

interface EstateService {

  @FormUrlEncoded
  @POST("user/login/oauth/kakao")
  suspend fun requestToken(
    @Field("accessToken") accessToken: String
  ): Response<TokenResponse>
}