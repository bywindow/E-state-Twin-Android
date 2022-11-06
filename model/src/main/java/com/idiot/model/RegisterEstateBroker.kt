package com.idiot.model

data class RegisterEstateBroker(
  val id: Int,
  val floorplan: String?,
  val transactionType: String,
  val arCam: String,
  val house: DetailHouse,
  val estatePhotos: List<String>,
  val estateVideos: List<String>,
  val assets: List<DetailAsset>
)
