package com.idiot.more.ui

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.idiot.more.R

public class MoreFragmentDirections private constructor() {
  public companion object {
    public fun actionMoreFragmentToRegisterFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_moreFragment_to_registerFragment)

    public fun actionMoreFragmentToMyPageFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_moreFragment_to_myPageFragment)
  }
}
