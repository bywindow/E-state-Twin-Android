package com.idiot.model

data class DetailAsset(
  val id: Int,
  var productName: String?,
  var manufacturer: String?,
  var anchorId: String?,
  var assetPhoto: String?,
  var repairDate: String?,
  val category: String, // HOMEAPPLIANCES, FURNITURE, BATHROOM, INTERIOR
  val option: String, // AIRCONDITIONER, WASHER, BED, DESK, CLOSET, TV, REFRIGERATOR, SHOERACK, GASSTOVE, DOORLOCK, BIDET, WALLPAPER, CURTAIN
)
