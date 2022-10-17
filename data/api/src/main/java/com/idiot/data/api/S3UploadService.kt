package com.idiot.data.api

import com.idiot.model.S3UploadResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.PartMap

interface S3UploadService {

  @Multipart
  @POST("upload/image/")
  suspend fun requestEstateImageUri(
    @Part files: List<MultipartBody.Part>
  ): Response<S3UploadResponse>

}