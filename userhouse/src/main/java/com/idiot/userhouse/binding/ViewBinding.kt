package com.idiot.userhouse.binding

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.idiot.userhouse.R

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
    when (estateType) {
      "OFFICETELS" -> view.text = "오피스텔"
      "APARTMENT" -> view.text = "아파트"
    }
  }

  @JvmStatic
  @BindingAdapter("assetImageUrl")
  fun bindAssetImageUrl(view: AppCompatImageView, assetImageUrl: String) {
    val context = view.context
    Glide.with(context)
      .load(assetImageUrl)
      .thumbnail(0.1f)
      .placeholder(ColorDrawable(Color.parseColor("#D1D1D1")))
      .error(com.idiot.utils.R.drawable.ic_image_error_2)
      .into(view)
  }

  @JvmStatic
  @BindingAdapter("categoryToText")
  fun bindCategoryToText(view: AppCompatTextView, categoryToText: String) {
    when (categoryToText) {
      "HOMEAPPLIANCES" -> view.setText(R.string.category_home_appliance)
      "FURNITURE" -> view.setText(R.string.category_furniture)
      "BATHROOM" -> view.setText(R.string.category_bathroom)
      "INTERIOR" -> view.setText(R.string.category_interior)
      else -> return
    }
  }

  @JvmStatic
  @BindingAdapter("optionToText")
  fun bindOptionToText(view: AppCompatTextView, optionToText: String) {
    when (optionToText) {
      "AIRCONDITIONER" -> view.text = "에어컨"
      "WASHER" -> view.text = "세탁기"
      "REFRIGERATOR" -> view.text = "냉장고"
      "GASSTOVE" -> view.text = "가스레인지"
      "MICROWAVE" -> view.text = "전자레인지"
      "DOORLOCK" -> view.text = "전자도어락"
      "INDUCTION" -> view.text = "인덕션"
      "TV" -> view.text = "TV"
      "BED" -> view.text = "참대"
      "CLOSET" -> view.text = "옷장"
      "DESK" -> view.text = "책상"
      "SHOERACK" -> view.text = "신발장"
      "BIDET" -> view.text = "비데"
      "WALLPAPER" -> view.text = "벽지"
      "CURTAIN" -> view.text = "커튼"
      else -> view.text = ""
    }
  }
}