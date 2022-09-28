package com.idiot.feature.login.utils

import android.app.Application
import android.graphics.Color
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.idiot.feature.login.R
import dagger.hilt.android.internal.Contexts.getApplication

object TransactionTypeUtils {

  fun getInactiveColor(view: AppCompatButton) {
    view.background = view.context.getDrawable(R.drawable.user_info_button_background)
    view.setTextColor(Color.DKGRAY)
  }

  fun getActiveColor(view: AppCompatButton) {
    view.setBackgroundColor(ContextCompat.getColor(view.context, com.idiot.common_ui.R.color.purple_700))
    view.setTextColor(Color.WHITE)
  }

  fun getSubCityList(city: Int, application: Application) : Array<String>{
    var sub: Array<String> = when (city) {
      0 -> application.resources.getStringArray(R.array.seoul_dist)
      1 -> application.resources.getStringArray(R.array.busan_dist)
      2 -> application.resources.getStringArray(R.array.daegu_dist)
      3 -> application.resources.getStringArray(R.array.incheon_dist)
      4 -> application.resources.getStringArray(R.array.gwangju_dist)
      5 -> application.resources.getStringArray(R.array.daejeon_dist)
      6 -> application.resources.getStringArray(R.array.ulsan_dist)
      7 -> application.resources.getStringArray(R.array.sejong_dist)
      8 -> application.resources.getStringArray(R.array.gyeonggi_dist)
      9 -> application.resources.getStringArray(R.array.gangwon_dist)
      10 -> application.resources.getStringArray(R.array.chungbuk_dist)
      11 -> application.resources.getStringArray(R.array.chungnam_dist)
      else -> arrayOf()
    }
    return sub
  }
}