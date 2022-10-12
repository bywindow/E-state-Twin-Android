package com.idiot.data.repository.di

import com.idiot.data.repository.TokenRepository
import com.idiot.data.repository.TokenRepositoryImpl
import com.idiot.data.repository.UserPreferenceRepository
import com.idiot.data.repository.UserPreferenceRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

  @Binds
  fun bindsTokenRepository(
    tokenRepositoryImpl: TokenRepositoryImpl
  ): TokenRepository

  @Binds
  fun bindsUserPreferencesRepository(
    userPreferenceRepositoryImpl: UserPreferenceRepositoryImpl
  ): UserPreferenceRepository
}