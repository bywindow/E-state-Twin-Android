package com.idiot.feature.login.bindings

import android.graphics.Color
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.databinding.BindingAdapter
import com.idiot.feature.login.R
import com.idiot.feature.login.utils.TransactionTypeUtils

object ViewBinding {

  @JvmStatic
  @BindingAdapter("isChecked")
  fun bindIsChecked(view: TextView, isChecked: Boolean) {
    if (isChecked) {
      view.setTextColor(Color.BLACK)
      view.setBackgroundColor(Color.WHITE)
    } else {
      view.setBackgroundColor(Color.LTGRAY)
      view.setTextColor(Color.DKGRAY)
    }
  }

  @JvmStatic
  @BindingAdapter("selectedType")
  fun bindSelectType(view: AppCompatButton, selectedType: Int) {
    when (view.id) {
      R.id.trading_button -> {
        if (selectedType == 1) {
          TransactionTypeUtils.getActiveColor(view)
        } else {
          TransactionTypeUtils.getInactiveColor(view)
        }
      }
      R.id.lease_button -> {
        if (selectedType == 2) {
          TransactionTypeUtils.getActiveColor(view)
        } else {
          TransactionTypeUtils.getInactiveColor(view)
        }
      }
      R.id.monthly_button -> {
        if (selectedType == 3) {
          TransactionTypeUtils.getActiveColor(view)
        } else {
          TransactionTypeUtils.getInactiveColor(view)
        }
      }
      else -> return
    }
  }

  @JvmStatic
  @BindingAdapter("selectedEstate")
  fun bindSelectEstate(view: AppCompatButton, selectedType: Int) {
    when (view.id) {
      R.id.apartment_button -> {
        if (selectedType == 1) {
          TransactionTypeUtils.getActiveColor(view)
        } else {
          TransactionTypeUtils.getInactiveColor(view)
        }
      }
      R.id.officetel_button -> {
        if (selectedType == 2) {
          TransactionTypeUtils.getActiveColor(view)
        } else {
          TransactionTypeUtils.getInactiveColor(view)
        }
      }
    }
  }

  @JvmStatic
  @BindingAdapter("isSubCity")
  fun bindIsSubCity(view: TextView, isChecked: Boolean) {
    if (isChecked) {
      view.setTextColor(Color.BLACK)
    } else {
      view.setTextColor(Color.LTGRAY)
    }
  }
}