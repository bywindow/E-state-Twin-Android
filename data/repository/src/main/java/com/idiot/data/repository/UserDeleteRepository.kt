package com.idiot.data.repository

import androidx.annotation.WorkerThread

interface UserDeleteRepository {

  @WorkerThread
  suspend fun requestDeleteUser(
    accessToken: String
  ): Int
}