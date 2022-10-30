package com.idiot.model

import java.io.Serializable

data class HouseOption(
    val id: Int,
    val icon: Int,
    val category: String,
    val key: String,
    val desc: String,
    var hasOption: Boolean,
    var anchorId: String? = null
) : Serializable
