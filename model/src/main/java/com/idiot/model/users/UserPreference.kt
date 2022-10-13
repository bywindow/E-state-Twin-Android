package com.idiot.model.users

data class UserPreference(
  val id: Int,
  val name: String,
  var isChecked: Boolean
)
