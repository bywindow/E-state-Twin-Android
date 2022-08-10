package com.idiot.e_state_twin_android.core.viewmodels

import androidx.lifecycle.ViewModel
import com.idiot.e_state_twin_android.R

class UserViewModel() : ViewModel() {

    val name: String = "홍길동"
    val profile: Int = R.drawable.ic_profile_default
    val role: String = "개인회원"
}