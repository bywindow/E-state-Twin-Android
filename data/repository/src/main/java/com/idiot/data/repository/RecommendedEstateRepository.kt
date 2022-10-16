package com.idiot.data.repository

import androidx.annotation.WorkerThread
import com.idiot.model.RecommendedEstate

interface RecommendedEstateRepository {

  @WorkerThread
  suspend fun requestRecommendedEstate(
    accessToken: String
  ): List<RecommendedEstate>?

}