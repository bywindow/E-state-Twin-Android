package com.idiot.data.repository

import androidx.annotation.WorkerThread
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class UserPreferenceRepositoryImpl @Inject constructor(
  private val userDataStorePreferences: DataStore<Preferences>
): UserPreferenceRepository {

  @WorkerThread
  override suspend fun setToken(accessToken: String, refreshToken: String) {
    Result.runCatching {
      userDataStorePreferences.edit {
        it[KEY_ACCESS_TOKEN] = accessToken
        it[KEY_REFRESH_TOKEN] = refreshToken
      }
    }
  }

  @WorkerThread
  override suspend fun getAccessToken(): Result<String> {
    return Result.runCatching {
      val flow = userDataStorePreferences.data.catch { exception ->
        if (exception is IOException) {
          emit(emptyPreferences())
        } else {
          throw exception
        }
      }.map { preferences ->
        preferences[KEY_ACCESS_TOKEN]
      }
      val value = flow.firstOrNull() ?:""
      value
    }
  }

  @WorkerThread
  override suspend fun setUserRole(role: String) {
    Result.runCatching {
      userDataStorePreferences.edit {
        it[KEY_USER_ROLE] = role
      }
    }
  }

  @WorkerThread
  override suspend fun getUserRole(): Result<String> {
    return Result.runCatching {
      val flow = userDataStorePreferences.data.catch { exception ->
        if (exception is IOException) {
          emit(emptyPreferences())
        } else {
          throw exception
        }
      }.map { preferences ->
        preferences[KEY_USER_ROLE]
      }
      val value = flow.firstOrNull() ?:""
      value
    }
  }

  private companion object {
    val KEY_ACCESS_TOKEN = stringPreferencesKey(name = "accessToken")
    val KEY_REFRESH_TOKEN = stringPreferencesKey(name = "refreshToken")
    val KEY_USER_ROLE = stringPreferencesKey(name = "role")
  }
}