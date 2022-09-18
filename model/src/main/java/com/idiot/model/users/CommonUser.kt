package com.idiot.model.users

data class CommonUser(
    val oauthId: String,
    val birthday: String?,
    val phone: String?,
    val name: String,
    val joinDate: String?,
    val nickname: String?,
    val email: String
)
