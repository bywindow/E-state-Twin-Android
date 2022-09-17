package com.idiot.e_state_twin_android

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.idiot.common_ui.MainActivity
import com.idiot.feature.login.LoginActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * TODO : Token 확인 ->
         *  token 이 없거나 만료되었다면 LoginActivity 로 이동
         *  token 이 있다면 유저정보를 가지고 MainActivity 로 이동
         */
        startActivity(Intent(this, LoginActivity::class.java))
//        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}