package com.idiot.model.users

data class TokenPreference(
  val accessToken: String,
  val refreshToken: String
)