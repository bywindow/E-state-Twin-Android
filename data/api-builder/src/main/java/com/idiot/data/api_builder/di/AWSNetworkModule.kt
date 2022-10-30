package com.idiot.data.api_builder.di

import com.idiot.data.api.AWSUploadService
import com.idiot.data.api_builder.BuildConfig
import com.idiot.data.api_builder.interceptor.HttpRequestInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AWSNetworkModule {

  private val client = OkHttpClient.Builder()
    .addInterceptor(HttpRequestInterceptor())
    .build()

  private val retrofit by lazy {
    Retrofit.Builder()
      .client(client)
      .baseUrl(BuildConfig.AWS_API_URI)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
  }

  val AWSUploadService : AWSUploadService by lazy {
    retrofit.create(AWSUploadService::class.java)
  }

}