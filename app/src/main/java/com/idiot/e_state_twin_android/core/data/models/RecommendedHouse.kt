package com.idiot.e_state_twin_android.core.data.models

import android.media.Image

data class RecommendedHouse(
    val houseId: Long,
    val imageUrl: Int?,
    val housePrice: String,
    val houseType: String,
    val houseAddress: String
)
