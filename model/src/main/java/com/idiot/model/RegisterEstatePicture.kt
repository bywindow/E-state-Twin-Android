package com.idiot.model

import android.net.Uri
import java.io.File

data class RegisterEstatePicture(
    val id: Long,
    val origFileName: String,
    val filePath: Uri,
    val file: File?
)
