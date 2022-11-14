package com.idiot.data.repository

import androidx.annotation.WorkerThread
import com.google.gson.Gson
import com.idiot.data.api.EstateClient
import com.idiot.model.Checklist
import com.idiot.model.RegisterCheckList
import okhttp3.RequestBody.Companion.toRequestBody
import javax.inject.Inject

class RegisterCheckListRepositoryImpl @Inject constructor(
  private val estateClient: EstateClient,
  private val userPreferenceRepository: UserPreferenceRepository
): RegisterCheckListRepository {

  @WorkerThread
  override suspend fun requestPostingCheckList(
    estateId: Long,
    assetId: Long,
    data: RegisterCheckList
  ) : Checklist? {
    val gson = Gson()
    val json = gson.toJson(data)
    val token = userPreferenceRepository.getAccessToken().getOrNull().orEmpty()
    val response = estateClient.requestPostingCheckList(
      accessToken = "Bearer $token",
      estateId = estateId,
      assetId = assetId,
      body = json.toRequestBody()
    )
    return if (response.isSuccessful) response.body() as Checklist else null
  }
}