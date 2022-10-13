package com.idiot.model

data class DetailAddress(
  val city: String,
  val borough: String,
  val town: String,
  val complexName: String,
  val block: String,
  val unit: String,
  val roadName: String,
  val mainBuildingNumber: Int,
  val subBuildingNumber: Int,
  val buildingName: String
)
