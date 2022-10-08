package com.idiot.data.api_builder.di

import com.idiot.data.api.EstateClient
import com.idiot.data.api.EstateService
import com.idiot.data.api_builder.BuildConfig
import com.idiot.data.api_builder.interceptor.HttpRequestInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

  @Provides
  @Singleton
  fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
      .addInterceptor(HttpRequestInterceptor())
      .build()
  }

  @Provides
  @Singleton
  fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
      .client(okHttpClient)
      .baseUrl(BuildConfig.BASE_API)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
  }

  @Provides
  @Singleton
  fun provideEstateService(retrofit: Retrofit): EstateService {
    return retrofit.create(EstateService::class.java)
  }

  @Provides
  @Singleton
  fun provideEstateClient(estateService: EstateService): EstateClient {
    return EstateClient(estateService)
  }
}