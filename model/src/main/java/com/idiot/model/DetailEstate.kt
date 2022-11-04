package com.idiot.model

data class DetailEstate(
  val id: Int,
  val state: String,
  val transactionType: String,
  val model: String,
  val createdAt: String,
  val estatePhotos: List<String>,
  val address: RoadAddressByOwner,
  val house: DetailHouse,
  val assets: List<AssetIncludingChecklist>
)
