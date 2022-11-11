package com.idiot.model.users

import com.squareup.moshi.Json

data class MyPageResponse(
  val id: Int,
  val name: String,
  val birthday: String,
  val email: String,
  val role: String,
  val broker: Boolean
)