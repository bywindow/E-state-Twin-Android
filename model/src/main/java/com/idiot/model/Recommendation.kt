package com.idiot.model

import android.net.Uri
import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Recommendation(
  @field:Json(name = "id") val id: Int,
  @field:Json(name = "transactionType") val transactionType: String,
  @field:Json(name = "estateThumbNail") val estateThumbNail: Uri,
  @field:Json(name = "town") val town: String,
  @field:Json(name = "estateType") val estateType: String,
  @field:Json(name = "buildingName") val buildingName: String,
  @field:Json(name = "currentFloors") val currentFloors: Int,
  @field:Json(name = "rentableArea") val rentableArea: Int,
  @field:Json(name = "state") val state: String
) : Parcelable
