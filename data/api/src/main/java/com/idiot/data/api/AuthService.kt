package com.idiot.data.api

import com.idiot.model.AuthCode
import com.idiot.model.AuthCodeResponse
import com.squareup.moshi.Json
import retrofit2.Response
import retrofit2.http.*

interface AuthService {
  @FormUrlEncoded
  @POST("user/login/oauth")
  suspend fun postLoginRequest(
    @Field("provider") provider: String
  ): Response<AuthCodeResponse>

  @GET("oauth/authorize")
  suspend fun getOauthCode(
    @Query("client_id") client_id: String = "c2128c91fe52c25d527f6de1f275f048",
    @Query("redirect_uri") redirect_uri: String = "www.estatetwin.net/oauth2/authorize/kakao",
    @Query("response_code") response_code: String = "code"
  )
}