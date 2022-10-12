package com.idiot.feature.login.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.idiot.feature.login.BuildConfig
import com.idiot.feature.login.ui.main.LoginActivity
import com.kakao.sdk.common.KakaoSdk
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * TODO : Token 확인 ->
         *  token 이 없거나 만료되었다면 LoginActivity 로 이동
         *  token 이 있다면 유저정보를 가지고 MainActivity 로 이동
         */
        KakaoSdk.init(this, BuildConfig.KAKAO_NATIVE_KEY)
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}