package com.idiot.data.repository

import androidx.annotation.WorkerThread
import com.idiot.model.Checklist
import com.idiot.model.RegisterCheckList

interface RegisterCheckListRepository {

  @WorkerThread
  suspend fun requestPostingCheckList(
    estateId: Long,
    assetId: Long,
    data: RegisterCheckList
  ) : Checklist?

}