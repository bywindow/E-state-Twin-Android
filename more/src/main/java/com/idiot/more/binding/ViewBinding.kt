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
    Timber.d("select: $selectedType")
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
      else -> return
    }
  }
}