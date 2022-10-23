package com.idiot.data.repository

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.net.Uri
import android.os.Build
import android.provider.OpenableColumns
import androidx.annotation.RequiresApi
import androidx.annotation.WorkerThread
import com.idiot.data.api_builder.di.S3NetworkModule
import com.idiot.model.S3UploadResponse
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okio.BufferedSink
import okio.source
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Response
import timber.log.Timber
import java.io.File
import javax.inject.Inject
import kotlin.reflect.typeOf


class EstateImageS3UploadRepository @Inject constructor() {

  @RequiresApi(Build.VERSION_CODES.O)
  @WorkerThread
  suspend fun requestImageUri(
    imageList: List<File>
  ): List<S3UploadResponse> {
    Timber.d("s3 image list: $imageList")
    val imagePartList = mutableListOf<MultipartBody.Part>()
//    imageList.forEach {
//      Timber.d("Repository: ${it}")
////      val requestBody = MultipartBody.Builder()
////        .setType(MultipartBody.FORM)
////        .addFormDataPart("files", it.name, RequestBody.create("image/*".toMediaTypeOrNull(), it))
////        .build()
//      val requestBody: RequestBody = it.asRequestBody("multipart/form-data".toMediaTypeOrNull())
//      imagePartList.add(MultipartBody.Part.createFormData(
//        name = "files",
//        filename = it.name,
//        body = requestBody
//      ))
//      Timber.d("CONTENT LENGTH: ${imagePartList.last().body}")
//    }
    Timber.d("upload image: ${imageList.last()}")
    val multipartBody = MultipartBody.Builder()
      .setType(MultipartBody.FORM)
      .addFormDataPart(
        "files",
        imageList.last().name,
        imageList.last().asRequestBody("image/*".toMediaTypeOrNull())
      ).build()
    Timber.d("s3 request file list: $imagePartList")
    val contentType = "multipart/form-data; boundary=${multipartBody.boundary}"
    var response: Response<List<S3UploadResponse>>? = null
    try {
      response = S3NetworkModule.s3UploadService.requestEstateImageUri(
        contentType = contentType,
        files = multipartBody
      )
    } catch (e: java.lang.IllegalStateException) {
      e.printStackTrace()
    } finally {
      Timber.d("s3 response: $response")
      Timber.d("lambda response body ${response?.body()?.last().toString().split("file_url=").last()}")
    }
    return response?.body() as List<S3UploadResponse>
  }
}