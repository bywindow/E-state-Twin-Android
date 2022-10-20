package com.idiot.data.repository

import com.idiot.data.api_builder.di.S3NetworkModule
import com.idiot.model.S3UploadResponse
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import timber.log.Timber
import java.io.File

class EstateImageS3UploadRepository() {

  suspend fun requestImageUri(
    imageList: String
  ): S3UploadResponse? {
    var imagePartList: MultipartBody.Part
    Timber.d("s3 imagelist: $imageList")
    val file = File(imageList)
    val requestFile: RequestBody = file.asRequestBody("image/*".toMediaType())
    imagePartList = MultipartBody.Part.createFormData("files", file.name, requestFile)
//    imageList?.forEach { image ->
//      val file = File(image)
//      Timber.d("s3 file: $file")
//      val requestFile: RequestBody = file.asRequestBody("multipart/form-data".toMediaType())
//      Timber.d("s3 request file: $requestFile")
//      imagePartList = MultipartBody.Part.createFormData("files", file.name, requestFile)
//    }
    Timber.d("s3 request file list: $imagePartList")
    val response = S3NetworkModule.s3UploadService.requestEstateImageUri(files = imagePartList)
    Timber.d("s3 response: $response")
    return if (response.isSuccessful) response.body() as S3UploadResponse else null
  }


}