package com.idiot.feature.login.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.idiot.common.MainActivity
import com.idiot.feature.login.BuildConfig
import com.idiot.feature.login.ui.main.LoginActivity
import com.idiot.feature.login.ui.main.LoginEvent
import com.idiot.feature.login.ui.main.LoginViewModel
import com.kakao.sdk.common.KakaoSdk
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import timber.log.Timber

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
        updateViewOnEvent(it)
      }
    }
  }

  private fun updateViewOnEvent(event: LoginEvent) {
    when (event) {
      is LoginEvent.CachedTokenFetchSuccess -> {
        val accessToken = event.accessToken
        Timber.d("TOKEN: $accessToken")
        if (accessToken.isEmpty()) {
          // 로컬에 저장된 토큰이 없을 때는 회원가입으로 이동하여 토큰 발급
          startActivity(Intent(this, LoginActivity::class.java))
        } else {
          // 로컬에 토큰정보가 있을 때는 로그인과정 없이 메인화면으로 이동
          startActivity(Intent(this, MainActivity::class.java))
        }
        finish()
      }
      LoginEvent.TokenCachedSuccess -> {}
    }
  }
}