package com.idiot.model

import java.io.Serializable

data class DetailAsset(
  val id: Int,
  var productName: String?,
  var manufacturer: String?,
  var anchorId: String?,
  var assetPhoto: String?,
  val option: String, // AIRCONDITIONER, WASHER, BED, DESK, CLOSET, TV, REFRIGERATOR, SHOERACK, GASSTOVE, DOORLOCK, BIDET, WALLPAPER, CURTAIN
  val category: String, // HOMEAPPLIANCES, FURNITURE, BATHROOM, INTERIOR
): Serializable
