package com.idiot.data.repository

import androidx.annotation.WorkerThread
import com.idiot.model.users.MyPageResponse

interface MyPageRepository {

  @WorkerThread
  suspend fun requestMyPage(
    accessToken: String
  ): MyPageResponse?
}