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
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream
import java.util.UUID

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

  private fun createTempFile(context: Context, fileName: String) : File {
    val storageDir : File? = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
    return File(storageDir, fileName)
  }

  private fun copyToFile(context: Context, uri: Uri, file: File) {
    val inputStream = context.contentResolver.openInputStream(uri)
    val outputStream = FileOutputStream(file)
    val buffer = ByteArray(4*1024)
    while (true) {
      val byteCount = inputStream!!.read(buffer)
      if (byteCount < 0) break
      outputStream.write(buffer, 0, byteCount)
    }
    outputStream.flush()
  }

  fun getImageRealPath(context: Context, uri: Uri): String? {
    val contentResolver: ContentResolver = context.contentResolver ?: return null
    val filePath: String =
      (context.applicationInfo.dataDir + File.separator + System.currentTimeMillis())
    Timber.d("File Path: $filePath")
    val file = File(filePath)
    try {
      val inputStream = contentResolver.openInputStream(uri) ?: return null
      Timber.d("INPUTSTREAM: $inputStream")
      val outputStream: OutputStream = FileOutputStream(file)
      val buf = ByteArray(1024)
      var len: Int
      while (inputStream.read(buf).also { len = it } > 0) outputStream.write(buf, 0, len)
      outputStream.close()
      inputStream.close()
    } catch (ignore: IOException) {
      return null
    }
    return file.absolutePath
  }

  fun generateBitmap(context: Context, uri: Uri): Bitmap = uri.let {
    if (Build.VERSION.SDK_INT < 28) {
      MediaStore.Images.Media.getBitmap(context.contentResolver, it)
    } else {
      val source = ImageDecoder.createSource(context.contentResolver, it)
      ImageDecoder.decodeBitmap(source)
    }
  }
}