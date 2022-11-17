package com.idiot.model

data class OwnerModeResponse(
  val address: RoadAddressByOwner,
  val estateType: String,
  val state: String
)
