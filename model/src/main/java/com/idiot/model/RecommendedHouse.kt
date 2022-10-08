package com.idiot.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecommendedHouse(
    val houseId: Long,
    val imageUrl: String,
    val housePrice: String,
    val houseType: String,
    val houseAddress: String
) : Parcelable
