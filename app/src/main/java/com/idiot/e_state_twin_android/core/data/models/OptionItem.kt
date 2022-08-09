package com.idiot.e_state_twin_android.core.data.models

import android.os.Parcelable
import com.idiot.e_state_twin_android.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class OptionItem(
    val id: Int,
    val icon: Int,
    val desc: String,
) : Parcelable