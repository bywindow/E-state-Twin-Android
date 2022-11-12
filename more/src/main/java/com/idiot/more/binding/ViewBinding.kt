package com.idiot.more.binding

import android.graphics.Color
import android.graphics.Typeface
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.databinding.BindingAdapter
import com.idiot.more.R
import com.idiot.more.util.SelectedTypeUtil

object ViewBinding {

  @JvmStatic
  @BindingAdapter("selectedType")
  fun bindSelectType(view: AppCompatButton, selectedType: Int) {
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
      R.id.has_duplex_button -> {
        if (selectedType == 1) {
          SelectedTypeUtil.getActiveBackground(view)
        } else {
          SelectedTypeUtil.getInactiveBackground(view)
        }
      }
      R.id.has_not_duplex_button -> {
        if (selectedType == 2) {
          SelectedTypeUtil.getActiveBackground(view)
        } else {
          SelectedTypeUtil.getInactiveBackground(view)
        }
      }
      R.id.has_veranda_button -> {
        if (selectedType == 1) {
          SelectedTypeUtil.getActiveBackground(view)
        } else {
          SelectedTypeUtil.getInactiveBackground(view)
        }
      }
      R.id.has_not_veranda_button -> {
        if (selectedType == 2) {
          SelectedTypeUtil.getActiveBackground(view)
        } else {
          SelectedTypeUtil.getInactiveBackground(view)
        }
      }
      R.id.short_able_button -> {
        if (selectedType == 1) {
          SelectedTypeUtil.getActiveBackground(view)
        } else {
          SelectedTypeUtil.getInactiveBackground(view)
        }
      }
      R.id.short_disable_button -> {
        if (selectedType == 2) {
          SelectedTypeUtil.getActiveBackground(view)
        } else {
          SelectedTypeUtil.getInactiveBackground(view)
        }
      }
      else -> return
    }
  }

  @JvmStatic
  @BindingAdapter("includeType")
  fun bindIncludeType(view: AppCompatButton, includeType: Map<Int, Boolean>) {
    when(view.id) {
      R.id.water_fee -> {
        if (includeType[0] == true) {
          SelectedTypeUtil.getActiveBackground(view)
        } else {
          SelectedTypeUtil.getInactiveBackground(view)
        }
      }
      R.id.internet_fee -> {
        if (includeType[1] == true) {
          SelectedTypeUtil.getActiveBackground(view)
        } else {
          SelectedTypeUtil.getInactiveBackground(view)
        }
      }
      R.id.electronic_fee -> {
        if (includeType[2] == true) {
          SelectedTypeUtil.getActiveBackground(view)
        } else {
          SelectedTypeUtil.getInactiveBackground(view)
        }
      }
      R.id.gas_fee -> {
        if (includeType[3] == true) {
          SelectedTypeUtil.getActiveBackground(view)
        } else {
          SelectedTypeUtil.getInactiveBackground(view)
        }
      }
    }
  }

  @JvmStatic
  @BindingAdapter("isGone")
  fun bindIsGone(view: View, isGone: Boolean) {
    view.visibility = if (isGone) {
      View.GONE
    } else {
      View.VISIBLE
    }
  }

  @JvmStatic
  @BindingAdapter("categoryToText")
  fun bindCategoryToText(view: TextView, categoryToText: String) {
    when (categoryToText) {
      "HOMEAPPLIANCES" -> view.setText(R.string.category_home_appliance)
      "FURNITURE" -> view.setText(R.string.category_furniture)
      "BATHROOM" -> view.setText(R.string.category_bathroom)
      "INTERIOR" -> view.setText(R.string.category_interior)
      else -> return
    }
  }

  @JvmStatic
  @BindingAdapter("isParking")
  fun bindIsParking(view: AppCompatButton, isParking: Boolean) {
    if (isParking) {
      SelectedTypeUtil.getActiveBackground(view)
    } else {
      SelectedTypeUtil.getInactiveBackground(view)
    }
  }

  @JvmStatic
  @BindingAdapter("selectedCategory")
  fun bindSelectedCategory(view: AppCompatButton, selectedCategory: Boolean) {
    if (selectedCategory) {
      view.setTextColor(view.context.resources.getColor(com.idiot.utils.R.color.purple_700, null))
      view.background = view.context.getDrawable(R.drawable.bg_asset_category_active)
    } else {
      view.setTextColor(Color.DKGRAY)
      view.background = view.context.getDrawable(R.drawable.bg_asset_category_inactive)
    }
  }

}