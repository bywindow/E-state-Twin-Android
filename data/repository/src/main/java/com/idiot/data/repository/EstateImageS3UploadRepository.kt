package com.idiot.data.repository

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.provider.OpenableColumns
import com.idiot.data.api_builder.di.S3NetworkModule
import com.idiot.model.S3UploadResponse
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okio.BufferedSink
import okio.source
import retrofit2.Response
import timber.log.Timber
import java.io.File

class EstateImageS3UploadRepository() {

  suspend fun requestImageUri(
    imageList: List<File>
  ): String {
    Timber.d("s3 image list: $imageList")
    val imagePartList = mutableListOf<MultipartBody.Part>()
    imageList.forEach {
      Timber.d("Repository: ${it.absoluteFile}")
//      it.asMultipart("files", context.contentResolver)?.let { image -> imagePartList.add(image) }
      imagePartList.add(MultipartBody.Part.createFormData(
        name = "files",
        filename = it.name,
        body = it.asRequestBody("image/*".toMediaType())
      ))
      Timber.d("CONTENT LENGTH: ${imagePartList.last().body.contentLength()}")
    }
    Timber.d("s3 request file list: $imagePartList")
    var response: Response<List<S3UploadResponse>>? = null
    try {
      response = S3NetworkModule.s3UploadService.requestEstateImageUri(files = imagePartList)
    } catch (e: java.lang.IllegalStateException) {
      e.printStackTrace()
    } finally {
      Timber.d("s3 response: $response")
    }
    return response?.body().toString()
  }

  @SuppressLint("Range")
  fun Uri.asMultipart(name: String, contentResolver: ContentResolver): MultipartBody.Part? {
    return contentResolver.query(this, null, null, null, null)?.let {
      if (it.moveToNext()) {
        val displayName = it.getString(it.getColumnIndex(OpenableColumns.DISPLAY_NAME));
        val requestBody = object : RequestBody() {
          override fun contentType(): MediaType? {
            return contentResolver.getType(this@asMultipart)?.toMediaType()
          }

          @SuppressLint("Recycle")
          override fun writeTo(sink: BufferedSink) {
            sink.writeAll(contentResolver.openInputStream(this@asMultipart)?.source()!!)
          }
        }
        it.close()
        MultipartBody.Part.createFormData(name, displayName, requestBody)
      } else {
        it.close()
        null
      }
    }
  }
}