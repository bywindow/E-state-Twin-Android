package com.idiot.data.api_builder

import android.util.Log
import com.idiot.data.api.AuthService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AuthResponse {
  private const val BASE_API = BuildConfig.BASE_API

  private val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

  private val client = OkHttpClient.Builder()
    .addInterceptor(logger)
    .build()

  private val retrofit by lazy {
    Retrofit.Builder()
      .baseUrl(BASE_API)
      .client(client)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
  }

  val getAuthCodeService : AuthService by lazy {
    retrofit.create(AuthService::class.java)
  }
}