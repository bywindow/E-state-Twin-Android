package com.idiot.feature.login

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.databinding.DataBindingUtil
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.common.SignInButton
import com.idiot.common_ui.MainActivity
import com.idiot.feature.login.databinding.ActivityLoginBinding
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.user.UserApiClient

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel by viewModels<LoginViewModel>()

    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var getTokenIdResult: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
//        setGoogleSignInClient()
        initContinueButton()
        initLoginClickListener(binding)
        subscribeUi(binding)


    }

//    private fun setGoogleSignInClient() {
//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestEmail()
//            .build()
//        googleSignInClient = GoogleSignIn.getClient(this, gso)
//    }
//    //TODO : switch token provider (google, kakao, naver)
//    private fun initGetTokenIdLauncher() {
//        getTokenIdResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
//            if (it.resultCode == Activity.RESULT_OK) {
//                val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
//                try {
//                    val account = task.getResult(ApiException::class.java)!!
//
//                }
//            }
//        }
//    }

    private fun initLoginClickListener(binding: ActivityLoginBinding) {
        binding.kakaoButton.setOnClickListener {
            Log.d("kakao", "clicked")
            val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
                if (error != null) {
                    Log.e("TAG", "로그인 실패", error)
                } else if (token != null) {
                    Log.i("TAG", "로그인 성공 ${token.accessToken}")
                    saveKakaoUser(token.accessToken)
                }
                Log.d("result==", "11")
            }

            // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
            if (UserApiClient.instance.isKakaoTalkLoginAvailable(this@LoginActivity)) {
                Log.d("isKakaoTalkLoginAvailable", "isKakaoTalkLoginAvailable(true) ")
                UserApiClient.instance.loginWithKakaoTalk(this@LoginActivity, callback = callback)
            } else {
                Log.d("isKakaoTalkLoginAvailable", "isKakaoTalkLoginAvailable(false) ")
                UserApiClient.instance.loginWithKakaoAccount(this@LoginActivity, callback = callback)
            }
        }
    }

    //TODO : 서버에 토큰 저장하고 회원가입 페이지로 이동
    private fun saveKakaoUser(token: String) {
        UserApiClient.instance.me { user, error ->
            if (error != null) {
                Log.d("TAG", "faild: $error")
            } else if (user != null) {
                Log.d("TAG", "${user.kakaoAccount?.email}")
                Log.d("TAG", "${user.kakaoAccount?.profile}")
            }
        }
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun navigateToKakao() {
        startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("http://www.estatetwin.net/oauth2/authorize/kakao")
            )
        )
    }

    private fun initContinueButton() {
        binding.continueButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
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
                window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
            }
        }
    }
}