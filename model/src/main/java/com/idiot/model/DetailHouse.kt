package com.idiot.model

data class DetailHouse(
  val deposit: Int,
  val monthlyRent: Int,
  val sellingFee: Int,
  val currentFloors: Int,
  val totalFloors: Int,
  val shortTermRent: Boolean,
  val maintenanceFee: Int,
  val itemsIncludedMaintenanceFee: String,
  val netRentableArea: Int,
  val rentableArea: Int,
  val parking: Boolean,
  val parkingFee: Int,
  val moveInAvailableDate: String,
  val heatType: String,
  val estateType: String,
  val elevator: Boolean,
  val duplex: Boolean,
  val structure: String,
  val veranda: Boolean
)
