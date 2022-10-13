package com.idiot.model

data class EstateListResponse(
  val id: Int,
  val estateThumbNail: String,
  val town: String,
  val buildingName: String,
  val currentFloors: Int,
  val rentableArea: Int,
  val sellingFee: Int,
  val state: String,
  val transactionType: String,
  val estateType: String
)
