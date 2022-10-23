package com.idiot.data.api

import com.idiot.model.S3UploadResponse
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface S3UploadService {

  @POST("upload/image/")
  suspend fun requestEstateImageUri(
    @Header("Content-Type") contentType: String,
    @Body files: RequestBody
  ): Response<List<S3UploadResponse>>

}