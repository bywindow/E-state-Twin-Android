package com.idiot.model

import com.idiot.model.users.UserInfo

data class PreferEstate(
  val user: UserInfo,
  val estate: EstateListResponse
)
