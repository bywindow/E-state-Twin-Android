package com.idiot.data.repository

import androidx.annotation.WorkerThread
import com.idiot.model.OwnerModeResponse

interface OwnerModeRepository {

  @WorkerThread
  suspend fun requestOwnerMode(
    accessToken: String
  ) : List<OwnerModeResponse>
}