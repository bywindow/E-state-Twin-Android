package com.idiot.data.api

import com.idiot.model.S3UploadResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface S3UploadService {

  @Multipart
  @POST("upload/image/")
  suspend fun requestEstateImageUri(
    @Part files: List<MultipartBody.Part>
  ): Response<List<S3UploadResponse>>

}