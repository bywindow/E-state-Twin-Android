package com.idiot.data.api

import com.idiot.model.DetailEstate
import com.idiot.model.EstateListBrokerResponse
import com.idiot.model.RecommendedEstate
import com.idiot.model.TokenResponse
import com.idiot.model.users.MyPageResponse
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
    @Header("Authorization") accessToken: String,
    @Body body: RequestBody
  ): Response<UserSignUpResponse>

  @GET("estate/main")
  suspend fun requestRecommendedEstate(
    @Header("Authorization") accessToken: String
  ): Response<List<RecommendedEstate>>

  @GET("user/me")
  suspend fun requestMyPage(
    @Header("Authorization") accessToken: String
  ): Response<MyPageResponse>

  @DELETE("/user")
  suspend fun requestDeleteUser(
    @Header("Authorization") accessToken: String
  ): Response<Int>

  @POST("estate/detail/owner")
  suspend fun requestPostEstateOwner(
    @Header("Content-Type") contentType: String = "application/json",
    @Header("Authorization") accessToken: String,
    @Query("brokerId") brokerId: Int = 1,
    @Body body: RequestBody
  ): Response<String>

  @GET("broker/estate")
  suspend fun requestGetEstateListBroker(
    @Header("Content-Type") contentType: String = "application/json",
    @Header("Authorization") accessToken: String,
    @Query("state") state: String
  ): Response<List<EstateListBrokerResponse>>

  @POST("estate/detail/broker")
  suspend fun requestPostEstateBroker(
    @Header("Content-Type") contentType: String = "application/json",
    @Header("Authorization") accessToken: String,
    @Body body: RequestBody
  ): Response<String>

  @GET("estate/detail/{estateId}")
  suspend fun requestGetDetailEstate(
    @Header("Content-Type") contentType: String = "application/json",
    @Header("Authorization") accessToken: String,
    @Path("estateId") estateId: Long
  ): Response<DetailEstate>
}