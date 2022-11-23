package com.idiot.data.repository

import androidx.annotation.WorkerThread
import com.idiot.model.AssetIncludingChecklist
import com.idiot.model.DetailEstate
import kotlinx.coroutines.flow.Flow

interface GetEstateDetailRepository {

  @WorkerThread
  suspend fun requestGetDetailEstate(
    estateId: Long
  ) : DetailEstate?

  @WorkerThread
  suspend fun requestGetAssets(
    assetId: Long
  ): AssetIncludingChecklist?

}