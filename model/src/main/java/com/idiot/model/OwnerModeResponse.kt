package com.idiot.model

data class OwnerModeResponse(
  val estateId: Long,
  val address: RoadAddressByOwner,
  val estateType: String,
  val state: String
)
