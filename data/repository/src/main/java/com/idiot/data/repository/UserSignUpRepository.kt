package com.idiot.data.repository

import androidx.annotation.WorkerThread
import com.idiot.model.users.UserSignUp
import com.idiot.model.users.UserSignUpResponse

interface UserSignUpRepository {

  @WorkerThread
  suspend fun requestSignUp(
    accessToken: String,
    data: UserSignUp
  ): UserSignUpResponse?

}