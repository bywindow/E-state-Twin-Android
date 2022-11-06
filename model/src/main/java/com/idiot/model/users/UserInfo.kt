package com.idiot.model.users

data class UserInfo(
  val id: Int,
  val birthday: String,
  val phone: String,
  val name: String,
  val email: String,
  val borough: String,
  val authProvider: String,
  val transactionType: String,
  val estateType: String,
  val role: String,
  val broker: Boolean
)
