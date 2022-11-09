package com.idiot.userhouse.binding

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
}