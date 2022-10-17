package com.idiot.data.api_builder.di

import com.idiot.data.api.S3UploadService
import com.idiot.data.api_builder.BuildConfig
import com.idiot.data.api_builder.interceptor.HttpRequestInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

object S3NetworkModule {

  private val client = OkHttpClient.Builder()
    .addInterceptor(HttpRequestInterceptor())
    .build()

  private val retrofit by lazy {
    Retrofit.Builder()
      .client(client)
      .baseUrl(BuildConfig.S3_API_URI)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
  }

  val s3UploadService : S3UploadService by lazy {
    retrofit.create(S3UploadService::class.java)
  }

}