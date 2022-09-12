package com.idiot.model

import android.net.Uri

data class RegisterPicture(
    val id: Long,
    val origFileName: String,
    val filePath: Uri
)
