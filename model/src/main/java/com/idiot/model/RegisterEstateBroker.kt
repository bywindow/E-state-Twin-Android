package com.idiot.model

data class RegisterEstateBroker(
  val id: Int,
  val floorplan: String,
  val content: String,
  val transactionType: String,
  val arCam: String,
  val house: DetailHouse,
  val estatePhotos: List<String>,
  val assets: List<DetailAsset>
)
