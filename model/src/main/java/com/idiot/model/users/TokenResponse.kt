package com.idiot.model

import com.squareup.moshi.Json
import java.util.*

data class TokenResponse(
  @field:Json(name = "accessToken") val accessToken: String,
  @field:Json(name = "refreshToken") val refreshToken: String,
  @field:Json(name = "isMember") val isMember: Boolean
)
