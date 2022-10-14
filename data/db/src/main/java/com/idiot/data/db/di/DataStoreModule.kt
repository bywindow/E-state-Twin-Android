package com.idiot.data.db.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

  private const val USER_PREFERENCE = "user_pref"
  private val Context.userDataStore: DataStore<Preferences> by preferencesDataStore(name = USER_PREFERENCE)

  @Provides
  @Singleton
  fun provideUserDataStorePreferences(@ApplicationContext appContext: Context): DataStore<Preferences> {
    return appContext.userDataStore
  }
}