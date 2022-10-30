package com.idiot.data.repository

import androidx.annotation.WorkerThread
import com.idiot.data.api_builder.di.AWSNetworkModule
import com.idiot.model.S3UploadResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Response
import timber.log.Timber
import java.io.File
import javax.inject.Inject


class EstateImageS3UploadRepository @Inject constructor() {

  @WorkerThread
  suspend fun requestImageUri(
    imageList: List<File>
  ): List<S3UploadResponse> {
    val multipartBody = MultipartBody.Builder().setType(MultipartBody.FORM)
    imageList.forEach { file ->
      multipartBody.addFormDataPart("files", file.name, file.asRequestBody())
    }
    val build = multipartBody.build()
    val contentType = "multipart/form-data; boundary=${build.boundary}"
    var response: Response<List<S3UploadResponse>>? = null
    try {
      response = AWSNetworkModule.s3UploadService.requestEstateImageUri(
        contentType = contentType,
        files = build
      )
    } catch (e: java.lang.IllegalStateException) {
      e.printStackTrace()
    } finally {
      Timber.d("s3 response: ${response}")
    }
    return if (response?.body() != null) response.body() as List<S3UploadResponse> else emptyList()
  }
}