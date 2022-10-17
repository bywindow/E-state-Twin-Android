package com.idiot.model

import com.squareup.moshi.Json

data class S3UploadResponse(
  @field:Json(name = "file_url") val fileUrl: String
)
