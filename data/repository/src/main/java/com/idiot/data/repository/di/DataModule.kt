package com.idiot.data.repository.di

import com.idiot.data.repository.*
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

  @Binds
  fun bindsUserSignUpRepository(
    userSignUpRepositoryImpl: UserSignUpRepositoryImpl
  ): UserSignUpRepository

  @Binds
  fun bindsRecommendedEstateRepository(
    recommendedEstateRepositoryImpl: RecommendedEstateRepositoryImpl
  ): RecommendedEstateRepository

}