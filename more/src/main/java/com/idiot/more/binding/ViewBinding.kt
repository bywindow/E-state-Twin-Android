package com.idiot.more.binding

import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.databinding.BindingAdapter
import com.idiot.more.R
import com.idiot.more.util.SelectedTypeUtil
import timber.log.Timber

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

}