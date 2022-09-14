package com.idiot.model

import android.graphics.drawable.Drawable

data class HouseOption(
    val id: Int,
    val icon: Int,
    val key: String,
    val desc: String,
    var hasOption: Boolean
)