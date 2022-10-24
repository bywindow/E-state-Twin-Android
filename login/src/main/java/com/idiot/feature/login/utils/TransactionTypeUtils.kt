package com.idiot.feature.login.utils

import android.content.Context
import android.graphics.Color
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.idiot.feature.login.R
import dagger.hilt.android.qualifiers.ApplicationContext

object TransactionTypeUtils {

  fun getInactiveColor(view: AppCompatButton) {
    view.background = view.context.getDrawable(R.drawable.user_info_button_background)
    view.setTextColor(Color.DKGRAY)
  }

  fun getActiveColor(view: AppCompatButton) {
    view.setBackgroundColor(ContextCompat.getColor(view.context, com.idiot.utils.R.color.purple_700))
    view.setTextColor(Color.WHITE)
  }

  fun getSubCityList(city: Int, @ApplicationContext context: Context) : Array<String>{
    var sub: Array<String> = when (city) {
      0 -> context.resources.getStringArray(R.array.seoul_dist)
      1 -> context.resources.getStringArray(R.array.busan_dist)
      2 -> context.resources.getStringArray(R.array.daegu_dist)
      3 -> context.resources.getStringArray(R.array.incheon_dist)
      4 -> context.resources.getStringArray(R.array.gwangju_dist)
      5 -> context.resources.getStringArray(R.array.daejeon_dist)
      6 -> context.resources.getStringArray(R.array.ulsan_dist)
      7 -> context.resources.getStringArray(R.array.sejong_dist)
      8 -> context.resources.getStringArray(R.array.gyeonggi_dist)
      9 -> context.resources.getStringArray(R.array.gangwon_dist)
      10 -> context.resources.getStringArray(R.array.chungbuk_dist)
      11 -> context.resources.getStringArray(R.array.chungnam_dist)
      else -> arrayOf()
    }
    return sub
  }
}