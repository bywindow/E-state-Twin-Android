package com.idiot.data.api

import com.idiot.model.TokenResponse
import com.idiot.model.users.UserSignUpResponse
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface EstateService {

  @POST("user/login/oauth/{provider}")
  suspend fun requestToken(
    @Path("provider") provider: String = "kakao",
    @Body body: String
  ): Response<TokenResponse>

  @POST("user/signup")
  suspend fun requestSignUp(
    @Header("X-AUTH-TOKEN") accessToken: String,
    @Body body: RequestBody
  ): Response<UserSignUpResponse>
}