package com.idiot.data.repository

import androidx.annotation.WorkerThread
import com.idiot.model.RegisterEstateBrokerResponse

interface DipEstateRepository {

  @WorkerThread
  suspend fun requestEstateDip(
    estateId: Long
  ): RegisterEstateBrokerResponse?

  @WorkerThread
  suspend fun requestEstateInquiry(
    estateId: Long
  ):RegisterEstateBrokerResponse?
}