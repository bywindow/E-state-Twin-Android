package com.idiot.more.util

import android.content.ContentResolver
import android.content.Context
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import timber.log.Timber
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream
import java.text.SimpleDateFormat
import java.util.*

object FileUtil {

  fun convertUriToFile(context: Context, uri: Uri): File {
    val fileName = getFileName(context, uri)
    val file = createTempFile(context, fileName)
    copyToFile(context, uri, file)
    return File(file.absolutePath)
  }

  private fun getFileName(context: Context, uri: Uri): String {
    val name = uri.toString().split("/").last()
    val ext = context.contentResolver.getType(uri)!!.split("/").last()
    return "$name.$ext"
  }

  private fun createTempFile(context: Context, fileName: String): File {
    val storageDir: File? = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
    return File(storageDir, fileName)
  }

  private fun copyToFile(context: Context, uri: Uri, file: File) {
    val inputStream = context.contentResolver.openInputStream(uri)
    val outputStream = FileOutputStream(file)
    val buffer = ByteArray(4 * 1024)
    while (true) {
      val byteCount = inputStream!!.read(buffer)
      if (byteCount < 0) break
      outputStream.write(buffer, 0, byteCount)
    }
    outputStream.flush()
  }

  fun generateFileName(): String {
    val date = SimpleDateFormat("yyyyMMddHHmmss", java.util.Locale.KOREA).format(Date())
    return "${
      Environment.getExternalStoragePublicDirectory(
        Environment.DIRECTORY_PICTURES
      )
    }${File.separator}checklist/$date/screenshot.jpg"
  }

  fun saveBitmapToDisk(bitmap: Bitmap, filename: String) {
    val out = File(filename)
    if (!out.parentFile.exists()) {
      out.parentFile.mkdirs()
    }
    val outputStream = FileOutputStream(filename)
    val outputData = ByteArrayOutputStream()
    try {
      bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputData)
      outputData.writeTo(outputStream)
    } catch (e: Exception) {
      e.printStackTrace()
    }
    outputStream.flush()
  }
}