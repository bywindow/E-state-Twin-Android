package com.idiot.model

import android.net.Uri
import com.google.gson.annotations.SerializedName

data class Recommendation(
    @SerializedName("id") val id: Int,
    @SerializedName("transactionType") val transactionType: String,
    @SerializedName("estateThumbNail") val estateThumbNail: Uri,
    @SerializedName("town") val town: String,
    @SerializedName("estateType") val estateType: String,
    @SerializedName("buildingName") val buildingName: String,
    @SerializedName("currentFloors") val currentFloors: Int,
    @SerializedName("rentableArea") val rentableArea: Int,
    @SerializedName("state") val state: String
)
