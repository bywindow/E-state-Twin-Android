package com.idiot.feature.login.ui.main

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.common.SignInButton
import com.idiot.feature.login.R
import com.idiot.feature.login.databinding.ActivityLoginBinding
import com.idiot.feature.login.utils.UpdateViewOnEvent.updateViewOnEvent
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.UserApiClient
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

  private lateinit var binding: ActivityLoginBinding
  private val viewModel: LoginViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
    initLoginClickListener(binding)
    subscribeUi(binding)
  }

  private fun initLoginClickListener(binding: ActivityLoginBinding) {
    binding.kakaoButton.setOnClickListener {

      val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
        if (error != null) {
          Log.e("TAG", "로그인 실패", error)
        } else if (token != null) {
          Log.i("TAG", "로그인 성공 $token")
          saveKakaoUser(token)
        }
      }
//       카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
      if (UserApiClient.instance.isKakaoTalkLoginAvailable(this@LoginActivity)) {
        Log.d("TAG", "isKakaoTalkLoginAvailable(true) ")
        UserApiClient.instance.loginWithKakaoTalk(this@LoginActivity, callback = callback)
      } else {
        Log.d("TAG", "isKakaoTalkLoginAvailable(false) ")
        UserApiClient.instance.loginWithKakaoAccount(this@LoginActivity, callback = callback)
      }
    }
  }

  //TODO : 서버에 토큰 저장하고 회원가입 페이지로 이동
  private fun saveKakaoUser(token: OAuthToken) {
    UserApiClient.instance.accessTokenInfo { tokenInfo, error ->
      if (error != null) {
        Log.e("TAG", "failed")
      } else if (tokenInfo != null) {
        Log.d("TAG", "$tokenInfo")
      }
    }
    UserApiClient.instance.me { user, error ->
      if (error != null) {
        Log.d("TAG", "faild: $error")
      } else if (user != null) {
        val scopes = mutableListOf<String>()
        if (user.kakaoAccount?.emailNeedsAgreement == true) {
          scopes.add("account_email")
        }
        if (user.kakaoAccount?.birthdayNeedsAgreement == true) {
          scopes.add("birthday")
        }
        if (user.kakaoAccount?.birthyearNeedsAgreement == true) {
          scopes.add("birthyear")
        }
        if (user.kakaoAccount?.genderNeedsAgreement == true) {
          scopes.add("gender")
        }
        if (user.kakaoAccount?.phoneNumberNeedsAgreement == true) {
          scopes.add("phone_number")
        }
        if (user.kakaoAccount?.profileNeedsAgreement == true) {
          scopes.add("profile")
        }
        if (user.kakaoAccount?.ageRangeNeedsAgreement == true) {
          scopes.add("age_range")
        }
        if (user.kakaoAccount?.ciNeedsAgreement == true) {
          scopes.add("account_ci")
        }

        if (scopes.isNotEmpty()) {
          UserApiClient.instance.loginWithNewScopes(this, scopes) { token, errorScope ->
            if (errorScope != null) {
              Log.e("TAG", "additional agree failed", errorScope)
            } else {
              Log.d("TAG", "allowed scopes: ${token!!.scopes}")
              UserApiClient.instance.me { user, error ->
                if (error != null) {
                  Log.e("TAG", "user request failed", error)
                } else if (user != null) {
                  Log.i("TAG", "user request success: $user")
                }
              }
            }
          }
        }
      }
    }
    lifecycleScope.launch {
      viewModel.requestToken(provider = "kakao", code = token.accessToken)
      Timber.d("token : ${viewModel.token.value}")
      val accessToken = viewModel.token.value?.accessToken.toString()
      val refreshToken = viewModel.token.value?.refreshToken.toString()
      val isMember = viewModel.token.value?.isMember ?: false

      viewModel.cacheToken(
        accessToken = accessToken,
        refreshToken = refreshToken
      ).collect {
        updateViewOnEvent(it, this@LoginActivity, isMember)
        finish()
      }
    }
  }

  private fun subscribeUi(binding: ActivityLoginBinding) {
    binding.googleButton.setSize(SignInButton.SIZE_ICON_ONLY)
  }

  override fun onWindowFocusChanged(hasFocus: Boolean) {
    super.onWindowFocusChanged(hasFocus)
    if (hasFocus) {
      WindowCompat.setDecorFitsSystemWindows(window, false)
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        val controller = window.insetsController
        controller.let {
          it!!.hide(WindowInsets.Type.navigationBars())
          it.systemBarsBehavior =
            WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
      } else {
//                window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
//                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
      }
    }
  }
}


