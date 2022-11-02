package com.idiot.data.repository

import androidx.annotation.WorkerThread
import com.idiot.model.RegisterEstateBroker
import org.json.JSONObject

interface RegisterEstateBrokerRepository {

  @WorkerThread
  suspend fun requestPostEstateBroker(
    accessToken: String,
    body: RegisterEstateBroker
  ): JSONObject
}