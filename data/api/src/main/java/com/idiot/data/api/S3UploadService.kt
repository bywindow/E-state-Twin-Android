package com.idiot.data.api

import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface S3UploadService {

  @POST("upload/image")
  suspend fun requestEstateImageUri(
    @Body body: RequestBody
  ): Response<String>

}