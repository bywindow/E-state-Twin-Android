package com.idiot.model.users

import com.squareup.moshi.Json

data class MyPageResponse(
  @field:Json(name = "id") val id: Int,
  @field:Json(name = "name") val name: String,
  @field:Json(name = "birthday") val birthday: String,
  @field:Json(name = "email") val email: String,
  @field:Json(name = "broker") val isBroker: Boolean
)

//{
//  "id": 16,
//  "birthday": [
//  2022,
//  1,
//  1
//  ],
//  "phone": "01000000000",
//  "name": "이게된다고",
//  "email": "daowll@naver.com",
//  "borough": "강남구",
//  "authProvider": "KAKAO",
//  "transactionType": "MONTHLYRENT",
//  "estateType": "APARTMENT",
//  "role": "USER",
//  "broker": true
//}