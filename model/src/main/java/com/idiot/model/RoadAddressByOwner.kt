package com.idiot.model

data class RoadAddressByOwner(
  val city: String,
  val borough: String,
  val block: String,
  val unit: String,
  val roadName: String,
  val mainBuildingNumber: Int,
  val subBuildingNumber: Int,
  val buildingName: String
)
