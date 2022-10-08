package com.idiot.data.repository.di

import com.idiot.data.repository.TokenRepository
import com.idiot.data.repository.TokenRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

  @Binds
  fun bindsTokenRepository(
    tokenRepositoryImpl: TokenRepositoryImpl
  ): TokenRepository
}