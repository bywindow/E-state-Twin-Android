package com.idiot.feature.login.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.idiot.feature.login.BuildConfig
import com.idiot.feature.login.ui.main.LoginViewModel
import com.idiot.feature.login.utils.UpdateViewOnEvent.updateViewOnEvent
import com.kakao.sdk.common.KakaoSdk
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashScreenActivity : AppCompatActivity() {

  private val viewModel by viewModels<LoginViewModel>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    KakaoSdk.init(this, BuildConfig.KAKAO_NATIVE_KEY)
    getAccessToken()
  }

  private fun getAccessToken(){
    lifecycleScope.launchWhenCreated {
      viewModel.getToken().collect() {
        updateViewOnEvent(it, this@SplashScreenActivity, false)
        finish()
      }
    }
  }
}