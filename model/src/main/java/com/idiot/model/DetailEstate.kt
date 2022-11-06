package com.idiot.model

import java.time.LocalDate
import java.time.LocalDateTime

data class DetailEstate(
  val id: Int,
  val state: String,
  val transactionType: String,
  val model: String,
  val createdAt: LocalDateTime,
  val estatePhotos: List<String>,
  val address: RoadAddressByOwner,
  val house: DetailHouse,
  val assets: List<AssetIncludingChecklist>
)
