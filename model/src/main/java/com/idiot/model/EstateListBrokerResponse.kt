package com.idiot.model

data class EstateListBrokerResponse(
  val estateId: Int,
  val ownerName: String,
  val ownerPhone: String,
  val estateAddress: RegisterEstateOwner
)
