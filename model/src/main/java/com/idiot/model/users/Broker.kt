package com.idiot.model.users

import com.idiot.model.DetailAddress

data class Broker(
  val businessName: String,
  val agentName: String,
  val brokerageRegistrationNumber: String,
  val businessRegistrationNumber: String,
  val businessLicense: String,
  val brokerageRegistrationLicense: String,
  val countOfTransactionCompletion: Int,
  val content: String,
  val address: DetailAddress
)
