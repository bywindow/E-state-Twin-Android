package com.idiot.data.api

import com.idiot.model.S3UploadResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface S3UploadService {

  @Multipart
  @POST("upload/image/")
  suspend fun requestEstateImageUri(
    @Header("Content-Type") contentType: String = "multipart/form-data",
    @Part files: MultipartBody.Part
  ): Response<S3UploadResponse>

}