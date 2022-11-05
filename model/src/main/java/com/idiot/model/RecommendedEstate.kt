package com.idiot.model

import com.squareup.moshi.Json

data class RecommendedEstate(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "estateThumbNail") val estateThumbNail: String,
    @field:Json(name = "town") val town: String,
    @field:Json(name = "thumbnail3D") val thumbnail3D: String,
    @field:Json(name = "sellingFee") val sellingFee: Int,
    @field:Json(name = "userBorough") val userBorough: String,
    @field:Json(name = "transactionType") val transactionType: String,
    @field:Json(name = "estateType") val estateType: String
)
