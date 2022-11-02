package com.idiot.model

data class RegisterEstateOwner(
  val city: String,
  val borough: String,
  val roadName: String,
  val mainBuildingNumber: Int,
  val subBuildingNumber: Int,
  val buildingName: String
)