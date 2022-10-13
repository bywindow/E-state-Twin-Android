package com.idiot.feature.login.utils

import android.content.Context
import android.content.Intent
import com.idiot.common.MainActivity
import com.idiot.feature.login.ui.main.LoginActivity
import com.idiot.feature.login.ui.main.LoginEvent
import com.idiot.feature.login.ui.sign.SignUpActivity
import com.idiot.feature.login.ui.sign.SignUpEvent
import dagger.hilt.android.qualifiers.ApplicationContext
import timber.log.Timber

object UpdateViewOnEvent {

  fun updateViewOnEvent(event: LoginEvent, @ApplicationContext context: Context, isMember: Boolean) {
    when (event) {
      is LoginEvent.CachedTokenFetchSuccess -> {
        val accessToken = event.accessToken
        Timber.d("TOKEN: $accessToken")
        if (accessToken.isEmpty() || accessToken == "null") {
          // 로컬에 저장된 토큰이 없을 때는 회원가입으로 이동하여 토큰 발급
          context.startActivity(Intent(context, LoginActivity::class.java))
        } else {
          // 로컬에 토큰정보가 있을 때는 로그인과정 없이 메인화면으로 이동
          context.startActivity(Intent(context, MainActivity::class.java))
        }
      }
      is LoginEvent.TokenCachedSuccess -> {
        // 토큰 저장 성공
        Timber.d("Token Saved Completely")
        if (isMember) {
          context.startActivity(Intent(context, MainActivity::class.java))
          Timber.d("이미 멤버입니다")
        } else {
          val intent = Intent(context, SignUpActivity::class.java)
          intent.putExtra("accessToken", event.accessToken)
          context.startActivity(intent)
          Timber.d("뉴비입니다")
        }
      }
    }
  }

  fun moveToMainActivity(event: SignUpEvent, @ApplicationContext context: Context) {
    when (event) {
      SignUpEvent.UserDataUploadSuccess -> {
        Timber.d("유저 정보 저장 성공")
        context.startActivity(Intent(context, MainActivity::class.java))
      }
      else -> {}
    }
  }
}