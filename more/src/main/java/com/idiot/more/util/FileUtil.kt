package com.idiot.more.util

import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import android.provider.MediaStore.Images.Media

object FileUtil {
  fun getImageFilePath(context: Context, uri: Uri): String? {
    var path: String? = null
    var cursor: Cursor? = null

    try {
      cursor = context.contentResolver.query(uri, arrayOf(Media.DATA), null, null, null)
      cursor?.let {
        it.moveToFirst()
        path = it.getString(it.getColumnIndex(Media.DATA))
      }
    } finally {
      cursor?.close()
    }

    return path
  }
}