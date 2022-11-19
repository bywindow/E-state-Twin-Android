package com.idiot.data.repository

import androidx.annotation.WorkerThread
import com.idiot.model.AssetIncludingChecklist
import com.idiot.model.OwnerModeResponse

interface OwnerModeRepository {

  @WorkerThread
  suspend fun requestOwnerMode() : List<OwnerModeResponse>

  @WorkerThread
  suspend fun requestOwnerAssetList(estateId: Long): List<AssetIncludingChecklist>

}