package com.idiot.more.ui

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.idiot.more.R

public class RegisterInfoFragmentDirections private constructor() {
  public companion object {
    public fun actionRegisterInfoFragmentToRegisterHouseInfoFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_registerInfoFragment_to_registerHouseInfoFragment)

    public fun actionRegisterInfoFragmentToAddressSearchDialogFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_registerInfoFragment_to_addressSearchDialogFragment)
  }
}
