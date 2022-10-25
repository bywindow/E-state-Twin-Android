package com.idiot.more.binding

import androidx.appcompat.widget.AppCompatButton
import androidx.databinding.BindingAdapter
import com.idiot.more.R
import com.idiot.more.util.SelectedTypeUtil
import timber.log.Timber

object ViewBinding {

  @JvmStatic
  @BindingAdapter("selectedType")
  fun bindSelectType(view: AppCompatButton, selectedType: Int) {
    when (view.id) {
      R.id.has_elevator_button -> {
        if (selectedType == 1) {
          SelectedTypeUtil.getActiveBackground(view)
        } else {
          SelectedTypeUtil.getInactiveBackground(view)
        }
      }
      R.id.has_not_elevator_button -> {
        if (selectedType == 2) {
          SelectedTypeUtil.getActiveBackground(view)
        } else {
          SelectedTypeUtil.getInactiveBackground(view)
        }
      }
      R.id.has_duplex_button -> {
        if (selectedType == 1) {
          SelectedTypeUtil.getActiveBackground(view)
        } else {
          SelectedTypeUtil.getInactiveBackground(view)
        }
      }
      R.id.has_not_duplex_button -> {
        if (selectedType == 2) {
          SelectedTypeUtil.getActiveBackground(view)
        } else {
          SelectedTypeUtil.getInactiveBackground(view)
        }
      }
      R.id.has_veranda_button -> {
        if (selectedType == 1) {
          SelectedTypeUtil.getActiveBackground(view)
        } else {
          SelectedTypeUtil.getInactiveBackground(view)
        }
      }
      R.id.has_not_veranda_button -> {
        if (selectedType == 2) {
          SelectedTypeUtil.getActiveBackground(view)
        } else {
          SelectedTypeUtil.getInactiveBackground(view)
        }
      }
      R.id.short_able_button -> {
        if (selectedType == 1) {
          SelectedTypeUtil.getActiveBackground(view)
        } else {
          SelectedTypeUtil.getInactiveBackground(view)
        }
      }
      R.id.short_disable_button -> {
        if (selectedType == 2) {
          SelectedTypeUtil.getActiveBackground(view)
        } else {
          SelectedTypeUtil.getInactiveBackground(view)
        }
      }
      else -> return
    }
  }

  @JvmStatic
  @BindingAdapter("includeType")
  fun bindIncludeType(view: AppCompatButton, includeType: Map<Int, Boolean>) {
    when(view.id) {
      R.id.water_fee -> {
        if (includeType[0] == true) {
          SelectedTypeUtil.getActiveBackground(view)
        } else {
          SelectedTypeUtil.getInactiveBackground(view)
        }
      }
      R.id.internet_fee -> {
        if (includeType[1] == true) {
          SelectedTypeUtil.getActiveBackground(view)
        } else {
          SelectedTypeUtil.getInactiveBackground(view)
        }
      }
      R.id.electronic_fee -> {
        if (includeType[2] == true) {
          SelectedTypeUtil.getActiveBackground(view)
        } else {
          SelectedTypeUtil.getInactiveBackground(view)
        }
      }
      R.id.gas_fee -> {
        if (includeType[3] == true) {
          SelectedTypeUtil.getActiveBackground(view)
        } else {
          SelectedTypeUtil.getInactiveBackground(view)
        }
      }
    }
  }
}