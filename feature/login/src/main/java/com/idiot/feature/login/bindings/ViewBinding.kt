package com.idiot.feature.login.bindings

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.idiot.feature.login.R

object ViewBinding {

  @BindingAdapter("isChecked")
  fun bindIsChecked(view: TextView, isChecked: Boolean) {
    if (isChecked) {
      view.setTextColor(R.color.city_text_color_active)
      view.setBackgroundColor(R.color.city_background_active)
    } else {
      view.setTextColor(R.color.city_text_color_inactive)
      view.setTextColor(R.color.city_background_inactive)
    }
  }

}