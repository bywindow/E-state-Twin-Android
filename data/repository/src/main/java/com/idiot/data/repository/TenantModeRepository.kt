package com.idiot.data.repository

import androidx.annotation.WorkerThread
import com.idiot.model.TenantModeResponse

interface TenantModeRepository {

  @WorkerThread
  suspend fun requestGetTenantMode() : TenantModeResponse?
}