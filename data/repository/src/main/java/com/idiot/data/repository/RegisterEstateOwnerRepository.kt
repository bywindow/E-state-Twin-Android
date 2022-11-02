package com.idiot.data.repository

import androidx.annotation.WorkerThread
import com.idiot.model.RegisterEstateOwner
import org.json.JSONObject

interface RegisterEstateOwnerRepository {

  @WorkerThread
  suspend fun requestEstateOwner(
    accessToken: String,
    data: RegisterEstateOwner
  ) : String

}