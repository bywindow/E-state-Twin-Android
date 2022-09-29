package com.idiot.more.ui

import android.os.Bundle
import androidx.navigation.NavDirections
import com.idiot.more.R
import kotlin.Int
import kotlin.Long

public class RegisterFragmentDirections private constructor() {
  private data class ActionRegisterFragmentToRegisterInfoFragment(
    public val estateId: Long
  ) : NavDirections {
    public override val actionId: Int = R.id.action_registerFragment_to_registerInfoFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putLong("estateId", this.estateId)
        return result
      }
  }

  public companion object {
    public fun actionRegisterFragmentToRegisterInfoFragment(estateId: Long): NavDirections =
        ActionRegisterFragmentToRegisterInfoFragment(estateId)
  }
}
