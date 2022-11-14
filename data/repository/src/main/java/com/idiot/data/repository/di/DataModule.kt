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

  @Binds
  fun bindsMyPageRepository(
    myPageRepositoryImpl: MyPageRepositoryImpl
  ): MyPageRepository

  @Binds
  fun bindsUserDeleteRepository(
    userDeleteRepositoryImpl: UserDeleteRepositoryImpl
  ): UserDeleteRepository

  @Binds
  fun bindsRegisterEstateBrokerRepository(
    registerEstateBrokerRepositoryImpl: RegisterEstateBrokerRepositoryImpl
  ): RegisterEstateBrokerRepository

  @Binds
  fun bindsRegisterEstateOwnerRepository(
    registerEstateOwnerRepositoryImpl: RegisterEstateOwnerRepositoryImpl
  ): RegisterEstateOwnerRepository

  @Binds
  fun bindsBrokerEstateListRepository(
    brokerEstateListRepositoryImpl: BrokerEstateListRepositoryImpl
  ): BrokerEstateListRepository

  @Binds
  fun bindsGetEstateDetailRepository(
    getEstateDetailRepositoryImpl: GetEstateDetailRepositoryImpl
  ): GetEstateDetailRepository

  @Binds
  fun bindsTenantModeRepository(
    tenantModeRepositoryImpl: TenantModeRepositoryImpl
  ): TenantModeRepository

  @Binds
  fun bindsDipEstateRepository(
    dipEstateRepositoryImpl: DipEstateRepositoryImpl
  ): DipEstateRepository

  @Binds
  fun bindsRegisterCheckListRepository(
    registerCheckListRepositoryImpl: RegisterCheckListRepositoryImpl
  ): RegisterCheckListRepository
}