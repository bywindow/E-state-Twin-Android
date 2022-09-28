package com.idiot.e_state_twin_android

import android.app.Application
import androidx.work.Configuration
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application(), Configuration.Provider {

  override fun getWorkManagerConfiguration(): Configuration =
    Configuration.Builder().build()

}