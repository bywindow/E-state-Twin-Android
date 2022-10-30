package com.idiot.data.api

import com.idiot.model.S3UploadResponse
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface S3UploadService {

  @POST("default/upload/image/")
  suspend fun requestEstateImageUri(
    @Header("Content-Type") contentType: String,
    @Body files: RequestBody
  ): Response<List<S3UploadResponse>>

  @POST("test/upload/floorplan")
  suspend fun requestEstateFloorPlan(
    @Header("Content-Type") contentType: String,
    @Query("estateId") estateId: Int,
    @Body files: RequestBody
  ): Response<S3UploadResponse>

}