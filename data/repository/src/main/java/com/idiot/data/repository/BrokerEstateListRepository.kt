package com.idiot.data.repository

import androidx.annotation.WorkerThread
import com.idiot.model.EstateListBrokerResponse

interface BrokerEstateListRepository {

  @WorkerThread
  suspend fun requestGetEstateListBroker(
    accessToken: String,
    state: String
  ) : List<EstateListBrokerResponse>?

}