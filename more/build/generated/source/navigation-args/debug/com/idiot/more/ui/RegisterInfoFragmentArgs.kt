package com.idiot.more.ui

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Long
import kotlin.jvm.JvmStatic

public data class RegisterInfoFragmentArgs(
  public val estateId: Long
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putLong("estateId", this.estateId)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("estateId", this.estateId)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): RegisterInfoFragmentArgs {
      bundle.setClassLoader(RegisterInfoFragmentArgs::class.java.classLoader)
      val __estateId : Long
      if (bundle.containsKey("estateId")) {
        __estateId = bundle.getLong("estateId")
      } else {
        throw IllegalArgumentException("Required argument \"estateId\" is missing and does not have an android:defaultValue")
      }
      return RegisterInfoFragmentArgs(__estateId)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): RegisterInfoFragmentArgs {
      val __estateId : Long?
      if (savedStateHandle.contains("estateId")) {
        __estateId = savedStateHandle["estateId"]
        if (__estateId == null) {
          throw IllegalArgumentException("Argument \"estateId\" of type long does not support null values")
        }
      } else {
        throw IllegalArgumentException("Required argument \"estateId\" is missing and does not have an android:defaultValue")
      }
      return RegisterInfoFragmentArgs(__estateId)
    }
  }
}
