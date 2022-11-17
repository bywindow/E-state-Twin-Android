package com.idiot.data.api

import com.idiot.model.*
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
  ): Response<RegisterEstateBrokerResponse> = estateService.requestPostEstateBroker(
    accessToken = accessToken,
    body = body
  )

  suspend fun requestGetDetailEstate(
    accessToken: String,
    estateId: Long
  ): Response<DetailEstate> = estateService.requestGetDetailEstate(
    accessToken = accessToken,
    estateId = estateId
  )

  suspend fun requestGetTenantMode(
    accessToken: String
  ): Response<TenantModeResponse> = estateService.requestGetTenantMode(
    accessToken = accessToken
  )

  suspend fun requestGetOwnerMode(
    accessToken: String
  ):Response<List<OwnerModeResponse>> = estateService.requestGetOwnerMode(
    accessToken = accessToken
  )

  suspend fun requestEstateDip(
    accessToken: String,
    estateId: Long
  ): Response<RegisterEstateBrokerResponse> = estateService.requestEstateDip(
    accessToken = accessToken,
    estateId = estateId
  )

  suspend fun requestEstateInquiry(
    accessToken: String,
    estateId: Long
  ): Response<RegisterEstateBrokerResponse> = estateService.requestEstateInquiry(
    accessToken = accessToken,
    estateId = estateId
  )

  suspend fun requestEstateContract(
    accessToken: String,
    estateId: Long
  ): Response<RegisterEstateBrokerResponse> = estateService.requestEstateContract(
    accessToken = accessToken,
    estateId = estateId
  )

  suspend fun requestGetTenantAssetList(
    accessToken: String,
    category: String
  ): Response<List<AssetIncludingChecklist>> = estateService.requestGetTenantAssetList(
    accessToken = accessToken,
    category = category
  )

  suspend fun requestPostingCheckList(
    accessToken: String,
    estateId: Long,
    assetId: Long,
    body: RequestBody
  ): Response<Checklist> = estateService.requestPostingCheckList(
    accessToken = accessToken,
    estateId = estateId,
    assetId = assetId,
    body = body
  )

  suspend fun requestEstateConfirm(
    accessToken: String,
    estateId: Long
  ): Response<RegisterEstateBrokerResponse> = estateService.requestEstateConfirm(
    accessToken = accessToken,
    estateId = estateId
  )

}