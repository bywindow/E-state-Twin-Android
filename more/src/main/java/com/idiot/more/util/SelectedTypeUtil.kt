package com.idiot.more.util

import androidx.appcompat.widget.AppCompatButton
import com.idiot.more.R

object SelectedTypeUtil {
  fun getInactiveBackground(view: AppCompatButton) {
    view.background = view.context.getDrawable(R.drawable.register_dialog_button_rounded)
    view.setTextColor(view.context.resources.getColor(com.idiot.utils.R.color.detail_info_content, view.context.theme))
  }

  fun getActiveBackground(view: AppCompatButton) {
    view.background = view.context.getDrawable(R.drawable.register_dialog_button_rounded_active)
    view.setTextColor(view.context.resources.getColor(com.idiot.utils.R.color.white, view.context.theme))
  }
}