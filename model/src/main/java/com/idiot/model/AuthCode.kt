package com.idiot.model

import com.squareup.moshi.Json
import java.util.*

data class AuthCode(
  val accessToken: String,
  val accessTokenExpiresAt: Date,
  val refreshToken: String,
  val refreshTokenExpiresAt: Date,
  val idToken: String? = null,
  val scopes: List<String>? = null
)

data class AuthCodeResponse(
  @field:Json(name = "accessToken") val accessToken: String,
  @field:Json(name = "accessToken") val refreshToken: String
)
