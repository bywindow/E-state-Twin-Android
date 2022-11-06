package com.idiot.model

data class AssetIncludingChecklist(
  val id: Int,
  var productName: String?,
  var manufacturer: String?,
  var anchorId: String?,
  var assetPhoto: String?,
  val option: String, // AIRCONDITIONER, WASHER, BED, DESK, CLOSET, TV, REFRIGERATOR, SHOERACK, GASSTOVE, DOORLOCK, BIDET, WALLPAPER, CURTAIN
  val category: String, // HOMEAPPLIANCES, FURNITURE, BATHROOM, INTERIOR
  val checkLists: List<Checklist>
)
