package com.idiot.data.repository

import androidx.annotation.WorkerThread
import com.idiot.data.api.EstateClient
import com.idiot.model.RecommendedEstate
import com.idiot.model.users.MyPageResponse
import timber.log.Timber
import javax.inject.Inject

class MyPageRepositoryImpl @Inject constructor(
  private val estateClient: EstateClient
) : MyPageRepository {

  @WorkerThread
  override suspend fun requestMyPage(accessToken: String): MyPageResponse? {
    val response = estateClient.requestMyPage("Bearer $accessToken")
    Timber.d("main response: $response")
    return if (response.isSuccessful) response.body() as MyPageResponse else null
  }
}