package com.idiot.data.repository

import androidx.annotation.WorkerThread
import com.idiot.model.EstateSearchResponse
import com.idiot.model.users.SearchByBorough

interface EstateSearchRepository {

  @WorkerThread
  suspend fun requestEstateSearchList(
    data: SearchByBorough
  ) : List<EstateSearchResponse>
}