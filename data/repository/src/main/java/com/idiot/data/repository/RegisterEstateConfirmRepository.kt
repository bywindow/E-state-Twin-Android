package com.idiot.data.repository

import androidx.annotation.WorkerThread
import com.idiot.model.RegisterEstateBrokerResponse

interface RegisterEstateConfirmRepository {

  @WorkerThread
  suspend fun requestEstateConfirm(
    estateId: Long
  ) : RegisterEstateBrokerResponse?
}