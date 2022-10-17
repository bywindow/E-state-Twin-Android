package com.idiot.data.repository

import android.app.Application
import com.idiot.data.api_builder.di.S3NetworkModule
import com.idiot.model.RegisterEstatePicture
import com.idiot.model.S3UploadResponse
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import timber.log.Timber
import java.io.File

class EstateImageS3UploadRepository() {

  suspend fun requestImageUri(
    imageList: List<String>?
  ): S3UploadResponse? {
    val imagePartList: MutableList<MultipartBody.Part> = mutableListOf()
    Timber.d("s3 imagelist: $imageList")
    imageList?.forEach { image ->
      val file = File(image)
      Timber.d("s3 file: $file")
      val requestFile: RequestBody = file.asRequestBody("image/*".toMediaType())
      Timber.d("s3 request file: $requestFile")
      imagePartList.add(MultipartBody.Part.createFormData("files", "estate_image", requestFile))
    }
    val response = S3NetworkModule.s3UploadService.requestEstateImageUri(files = imagePartList)
    Timber.d("s3 response: $response")
    return if (response.isSuccessful) response.body() as S3UploadResponse else null
  }


}