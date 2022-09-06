package com.idiot.model.register

import android.net.Uri

data class RegisterPicture(
    val id: Long,
    val origFileName: String,
    val filePath: Uri
)
