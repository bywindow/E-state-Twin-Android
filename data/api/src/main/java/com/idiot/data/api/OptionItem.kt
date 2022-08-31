package com.idiot.data.api

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class OptionItem(
    val id: Int,
    val icon: Int,
    val desc: String,
) : Parcelable