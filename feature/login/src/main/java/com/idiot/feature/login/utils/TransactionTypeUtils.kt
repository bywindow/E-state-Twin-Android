package com.idiot.feature.login.utils

import android.graphics.Color
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.idiot.feature.login.R

object TransactionTypeUtils {

  fun getInactiveColor(view: AppCompatButton) {
    view.background = view.context.getDrawable(R.drawable.user_info_button_background)
    view.setTextColor(Color.DKGRAY)
  }

  fun getActiveColor(view: AppCompatButton) {
    view.setBackgroundColor(ContextCompat.getColor(view.context, com.idiot.common_ui.R.color.purple_700))
    view.setTextColor(Color.WHITE)
  }
}