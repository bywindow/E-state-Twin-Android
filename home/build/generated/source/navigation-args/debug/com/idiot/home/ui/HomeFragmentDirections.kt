package com.idiot.home.ui

import android.os.Bundle
import androidx.navigation.NavDirections
import com.idiot.home.R
import kotlin.Int
import kotlin.Long

public class HomeFragmentDirections private constructor() {
  private data class ActionHomeFragmentToHouseDetailFragment(
    public val houseId: Long
  ) : NavDirections {
    public override val actionId: Int = R.id.action_homeFragment_to_houseDetailFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putLong("houseId", this.houseId)
        return result
      }
  }

  public companion object {
    public fun actionHomeFragmentToHouseDetailFragment(houseId: Long): NavDirections =
        ActionHomeFragmentToHouseDetailFragment(houseId)
  }
}
