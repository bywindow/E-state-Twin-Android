package com.idiot.model.users

import com.idiot.model.RoadAddressByOwner

data class BrokerResponse(
  val id : Long,
  val businessName: String,
  val agentName: String,
  val address: RoadAddressByOwner,
  val phone: String,
  val brokerPhoto: String
)
