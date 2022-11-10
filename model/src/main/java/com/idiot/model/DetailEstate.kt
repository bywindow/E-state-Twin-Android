package com.idiot.model

import com.idiot.model.users.BrokerResponse

data class DetailEstate(
  val id: Long,
  val state: String,
  val transactionType: String,
  val model: String,
  val createdAt: String,
  val estatePhotos: List<String>,
  val address: RoadAddressByOwner,
  val house: DetailHouse,
  val broker: BrokerResponse,
  val assets: List<AssetIncludingChecklist>,
  var inquiry: Boolean,
  val posted: Boolean
)
