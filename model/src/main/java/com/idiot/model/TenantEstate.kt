package com.idiot.model

import com.idiot.model.users.Broker
import com.idiot.model.users.CommonUser
import com.idiot.model.users.UserSignUpResponse

//TODO: assets 부터 추가
data class TenantEstate(
  val estateThumbNail: String,
  val content: String,
  val model: String,
  val thumbnail3D: String,
  val arCam: String,
  val ownerConfirmYN: Boolean,
  val brokerConfirmYN: Boolean,
  val transactionType: String,
  val state: String,
  val grade: String,
  val address: DetailAddress,
  val estateHit: EstateHit,
  val house: DetailHouse,
  val broker: Broker,
  val owner: UserSignUpResponse,
  val tenant: CommonUser,
  val estateMedia: List<String>,
)
