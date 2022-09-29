package com.idiot.more.ui.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.idiot.more.R
import com.idiot.more.databinding.ListItemBuildingTypeSpinnerBinding
import java.lang.Exception

class BuildingTypeSpinnerAdapter(
  context: Context,
  @LayoutRes private val resId: Int,
  private val types: Array<String>
) : ArrayAdapter<String>(context, resId, types) {

  override fun getCount() = types.size

  override fun getItem(position: Int) = types[position]

  override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
    val binding: ListItemBuildingTypeSpinnerBinding = DataBindingUtil.inflate(
      LayoutInflater.from(parent.context), R.layout.list_item_building_type_spinner, parent, false
    )
    val model = types[position]
    try {
      binding.type = model
      binding.buildingTypeItem.setTextColor(
        ContextCompat.getColor(
          context,
          R.color.register_info_edit_text_hint
        )
      )
    } catch (e: Exception) {
      e.printStackTrace()
    }
    return binding.root
  }

  override fun isEnabled(position: Int): Boolean {
    return position != 0
  }

  override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
    val binding: ListItemBuildingTypeSpinnerBinding = DataBindingUtil.inflate(
      LayoutInflater.from(parent.context), R.layout.list_item_building_type_spinner, parent, false
    )
    val model = types[position]
    try {
      binding.type = model
//      if (position == 0) binding.buildingTypeItem.visibility = View.GONE
      if (position != 0) binding.buildingTypeItem.setTextColor(Color.BLACK)
    } catch (e: Exception) {
      e.printStackTrace()
    }
    return binding.root
  }
}