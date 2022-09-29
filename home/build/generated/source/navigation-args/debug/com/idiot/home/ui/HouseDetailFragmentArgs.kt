package com.idiot.home.ui

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Long
import kotlin.jvm.JvmStatic

public data class HouseDetailFragmentArgs(
  public val houseId: Long
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putLong("houseId", this.houseId)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("houseId", this.houseId)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): HouseDetailFragmentArgs {
      bundle.setClassLoader(HouseDetailFragmentArgs::class.java.classLoader)
      val __houseId : Long
      if (bundle.containsKey("houseId")) {
        __houseId = bundle.getLong("houseId")
      } else {
        throw IllegalArgumentException("Required argument \"houseId\" is missing and does not have an android:defaultValue")
      }
      return HouseDetailFragmentArgs(__houseId)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): HouseDetailFragmentArgs {
      val __houseId : Long?
      if (savedStateHandle.contains("houseId")) {
        __houseId = savedStateHandle["houseId"]
        if (__houseId == null) {
          throw IllegalArgumentException("Argument \"houseId\" of type long does not support null values")
        }
      } else {
        throw IllegalArgumentException("Required argument \"houseId\" is missing and does not have an android:defaultValue")
      }
      return HouseDetailFragmentArgs(__houseId)
    }
  }
}
