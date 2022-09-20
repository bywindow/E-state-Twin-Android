package com.idiot.e_state_twin_android

import android.app.Application
import androidx.work.Configuration
import com.idiot.feature.login.BuildConfig
import com.kakao.sdk.common.KakaoSdk

class MainApplication : Application(), Configuration.Provider {

    override fun getWorkManagerConfiguration(): Configuration =
        Configuration.Builder().build()
}