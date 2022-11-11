package com.idiot.model

data class EstateListBrokerResponse(
  val estateId: Long,
  val ownerName: String,
  val ownerPhone: String,
  val estateAddress: RegisterEstateOwner
)
