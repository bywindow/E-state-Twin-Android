package com.idiot.model

import com.squareup.moshi.Json

data class S3UploadResponse(
  @field:Json(name = "data") val data: UrlData,
  @field:Json(name = "file_url") val fileUrl: String
)

data class UrlData(
  @field:Json(name = "ETag") val eTag: String,
  @field:Json(name = "Location") val location: String,
  @field:Json(name = "key") val key: String,
  @field:Json(name = "Bucket") val bucket: String
)