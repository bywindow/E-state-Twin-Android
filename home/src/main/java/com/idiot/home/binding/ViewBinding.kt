package com.idiot.home.binding

import android.graphics.Color
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.databinding.BindingAdapter
import com.idiot.data.repository.R

object ViewBinding {

  @JvmStatic
  @BindingAdapter("assetName")
  fun bindAssetName(view: TextView, key: String) {
    when (key) {
      "AIRCONDITIONER" -> view.text = "에어컨"
      "WASHER" -> view.text = "세탁기"
      "BED" -> view.text = "침대"
      "DESK" -> view.text = "책상"
      "CLOSET" -> view.text = "옷장"
      "TV" -> view.text = "TV"
      "REFRIGERATOR" -> view.text = "냉장고"
      "SHOERACK" -> view.text = "신발장"
      "GASSTOVE" -> view.text = "가스레인지"
      "DOORLOCK" -> view.text = "전자도어락"
      "BIDET" -> view.text = "비데"
      "INDUCTION" -> view.text = "인덕션"
      "MICROWAVE" -> view.text = "전자레인지"
      "WALLPAPER" -> view.text = "벽지"
      "CURTAIN" -> view.text = "커튼"
      else -> view.text = ""
    }
  }

  @JvmStatic
  @BindingAdapter("assetImage")
  fun bindAssetImageSource(view: ImageView, key: String) {
    when (key) {
      "AIRCONDITIONER" -> view.setImageResource(R.drawable.ic_option_ac)
      "WASHER" -> view.setImageResource(R.drawable.ic_option_laundry)
      "BED" -> view.setImageResource(R.drawable.ic_option_bed)
      "DESK" -> view.setImageResource(R.drawable.ic_option_desk)
      "CLOSET" -> view.setImageResource(R.drawable.ic_option_closet)
      "TV" -> view.setImageResource(R.drawable.ic_option_tv)
      "REFRIGERATOR" -> view.setImageResource(R.drawable.ic_option_refrigerator)
      "SHOERACK" -> view.setImageResource(R.drawable.ic_option_shoes)
      "GASSTOVE" -> view.setImageResource(R.drawable.ic_option_gas)
      "DOORLOCK" -> view.setImageResource(R.drawable.ic_option_doorlock)
      "BIDET" -> view.setImageResource(R.drawable.ic_option_bidet)
      "INDUCTION" -> view.setImageResource(R.drawable.ic_option_induction)
      "MICROWAVE" -> view.setImageResource(R.drawable.ic_option_wave)
      "WALLPAPER" -> view.setImageResource(R.drawable.ic_option_wall)
      "CURTAIN" -> view.setImageResource(R.drawable.ic_option_curtain)
      else -> return
    }
  }

  @JvmStatic
  @BindingAdapter("inquired")
  fun bindAccessAble(view: AppCompatButton, inquired: Boolean) {
    if (inquired) {
      view.setCompoundDrawablesWithIntrinsicBounds(null, view.context.resources.getDrawable(com.idiot.home.R.drawable.ic_detail_ar_camera_active, null), null, null)
      view.setTextColor(Color.BLACK)
    } else {
      view.setCompoundDrawablesWithIntrinsicBounds(null, view.context.resources.getDrawable(com.idiot.home.R.drawable.ic_detail_ar_camera_inactive, null), null, null)
      view.setTextColor(com.idiot.home.R.color.detail_info_content)
    }
  }
}