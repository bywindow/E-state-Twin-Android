package com.idiot.model

data class DetailAsset(
  val createdDate: String,
  val modifiedDate: String,
  val id: Int,
  val productName: String,
  val manufacturer: String,
  val anchorId: String,
  val assetPhoto: String,
  val repairDate: String,
  val category: String, // HOMEAPPLIANCES, FURNITURE, BATHROOM, INTERIOR
  val option: String, // AIRCONDITIONER, WASHER, BED, DESK, CLOSET, TV, REFRIGERATOR, SHOERACK, GASSTOVE, DOORLOCK, BIDET, WALLPAPER, CURTAIN
  val estate: TenantEstate
)
