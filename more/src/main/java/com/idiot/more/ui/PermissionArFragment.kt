package com.idiot.more.ui

import android.Manifest
import com.google.ar.sceneform.ux.ArFragment

class PermissionArFragment : ArFragment() {
  override fun getAdditionalPermissions(): Array<String> {
    val additionalPermission: MutableList<String> = super.getAdditionalPermissions().toMutableList()
    additionalPermission.add(0, Manifest.permission.WRITE_EXTERNAL_STORAGE)
    return additionalPermission.toTypedArray()
  }
}