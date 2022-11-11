package com.idiot.data.repository

import androidx.annotation.WorkerThread
import com.idiot.data.api_builder.di.AWSNetworkModule
import com.idiot.model.AWSUploadResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Response
import timber.log.Timber
import java.io.File
import javax.inject.Inject

class EstateFloorPlanUploadRepository @Inject constructor() {

  @WorkerThread
  suspend fun requestEstateFloorPlan(estateId: Long, file: File): AWSUploadResponse? {
    val multipartBody = MultipartBody.Builder().setType(MultipartBody.FORM).apply {
      addFormDataPart("files", file.name, file.asRequestBody())
    }
    val build = multipartBody.build()
    val contentType = "multipart/form-data; boundary=${build.boundary}"
    var response : Response<AWSUploadResponse>? = null
    try {
        response = AWSNetworkModule.awsUploadService.requestEstateFloorPlan(contentType, estateId, build)
    } catch (e: Exception) {
      e.printStackTrace()
    } finally {
        Timber.d("aws response: ${response?.body()}")
    }
    return if (response?.body() != null) response.body() as AWSUploadResponse else null
  }
}