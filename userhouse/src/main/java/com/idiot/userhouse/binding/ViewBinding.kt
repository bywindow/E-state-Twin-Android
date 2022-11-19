package com.idiot.userhouse.binding

import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object ViewBinding {
  @JvmStatic
  @BindingAdapter("paletteImage")
  fun bindPaletteImage(view: AppCompatImageView, url: String) {
    val context = view.context
    Glide.with(context)
      .load(url)
      .into(view)
  }

  @JvmStatic
  @BindingAdapter("estateType")
  fun bindEstateType(view: TextView, estateType: String) {
    when(estateType) {
      "OFFICETELS" -> view.text = "오피스텔"
      "APARTMENT" -> view.text = "아파트"
    }
  }
}