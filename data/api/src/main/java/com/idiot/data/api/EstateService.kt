package com.idiot.data.api

import com.idiot.model.*
import com.idiot.model.serializer.PageAble
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
  ): Response<RegisterEstateBrokerResponse>

  @GET("estate/detail/{estateId}")
  suspend fun requestGetDetailEstate(
    @Header("Content-Type") contentType: String = "application/json",
    @Header("Authorization") accessToken: String,
    @Path("estateId") estateId: Long
  ): Response<DetailEstate>

  @GET("asset/{assetId}")
  suspend fun requestGetAssets(
    @Header("Content-Type") contentType: String = "application/json",
    @Header("Authorization") accessToken: String,
    @Path("assetId") assetId: Long
  ): Response<AssetIncludingChecklist>

  @GET("user/tenant/list")
  suspend fun requestGetTenantMode(
    @Header("Content-Type") contentType: String = "application/json",
    @Header("Authorization") accessToken: String
  ): Response<TenantModeResponse>

  @GET("user/owner/list")
  suspend fun requestGetOwnerMode(
    @Header("Content-Type") contentType: String = "application/json",
    @Header("Authorization") accessToken: String
  ): Response<List<OwnerModeResponse>>

  @GET("user/tenant/detail")
  suspend fun requestGetTenantAssetList(
    @Header("Content-Type") contentType: String = "application/json",
    @Header("Authorization") accessToken: String,
    @Query("category") category: String
  ): Response<List<AssetIncludingChecklist>>

  @GET("user/owner/detail")
  suspend fun requestGetOwnerAssetList(
    @Header("Content-Type") contentType: String = "application/json",
    @Header("Authorization") accessToken: String,
    @Query("estateId") estateId: Long
  ) : Response<List<AssetIncludingChecklist>>

  @PATCH("estate/detail/{estateId}/dip")
  suspend fun requestEstateDip(
    @Header("Content-Type") contentType: String = "application/json",
    @Header("Authorization") accessToken: String,
    @Path("estateId") estateId: Long
  ): Response<RegisterEstateBrokerResponse>

  @PATCH("estate/detail/{estateId}/inquiry")
  suspend fun requestEstateInquiry(
    @Header("Content-Type") contentType: String = "application/json",
    @Header("Authorization") accessToken: String,
    @Path("estateId") estateId: Long
  ): Response<RegisterEstateBrokerResponse>

  @PATCH("estate/detail/{estateId}/contract")
  suspend fun requestEstateContract(
    @Header("Content-Type") contentType: String = "application/json",
    @Header("Authorization") accessToken: String,
    @Path("estateId") estateId: Long
  ): Response<RegisterEstateBrokerResponse>

  @GET("preferestate/list/inquiry")
  suspend fun requestInquiredEstateList(
    @Header("Content-Type") contentType: String = "application/json",
    @Header("Authorization") accessToken: String,
    @Query("pageable") pageAble: PageAble
  ): Response<List<InquiredEstate>>

  @POST("checklist/estate/{estateId}/asset/{assetId}")
  suspend fun requestPostingCheckList(
    @Header("Content-Type") contentType: String = "application/json",
    @Header("Authorization") accessToken: String,
    @Path("estateId") estateId: Long,
    @Path("assetId") assetId: Long,
    @Body body: RequestBody
  ): Response<Checklist>

  @PATCH("estate/detail/{estateId}/allowPost")
  suspend fun requestEstateConfirm(
    @Header("Content-Type") contentType: String = "application/json",
    @Header("Authorization") accessToken: String,
    @Path("estateId") estateId: Long
  ): Response<RegisterEstateBrokerResponse>

  @POST("estate/search/list")
  suspend fun requestEstateSearchList(
    @Header("Content-Type") contentType: String = "application/json",
    @Header("Authorization") accessToken: String,
    @Query("page") page: Int = 0,
    @Query("size") size: Int? = 100,
    @Query("sort") sort: List<String> = listOf(""),
    @Body body: RequestBody
  ): Response<List<EstateSearchResponse>>
}