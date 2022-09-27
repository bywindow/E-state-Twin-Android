package com.idiot.feature.login.ui.sign

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.NO_POSITION
import com.idiot.feature.login.R
import com.idiot.feature.login.databinding.ListItemCitiesBinding

class CityAdapter(private val selectedPosition: Int) : ListAdapter<String, CityAdapter.ViewHolder>(diffUtil) {

  inner class ViewHolder(private val binding: ListItemCitiesBinding) :
    RecyclerView.ViewHolder(binding.root) {

    init {
      binding.root.setOnClickListener {
        val position =
          bindingAdapterPosition.takeIf { it != NO_POSITION } ?: return@setOnClickListener
        Log.d("TAG", "$position")
      }
    }

    fun bind(item: String, position: Int) {
      binding.city = item
      binding.isSelected = position == selectedPosition
      binding.executePendingBindings()
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(
      DataBindingUtil.inflate(
        LayoutInflater.from(parent.context),
        R.layout.list_item_cities,
        parent,
        false
      )
    )
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int, payloads: MutableList<Any>) {
    if (payloads.isEmpty()) super.onBindViewHolder(holder, position, payloads)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(getItem(position), position)
  }

  companion object {
    private val diffUtil = object : DiffUtil.ItemCallback<String>() {
      override fun areItemsTheSame(oldItem: String, newItem: String): Boolean =
        oldItem == newItem

      override fun areContentsTheSame(oldItem: String, newItem: String): Boolean =
        oldItem == newItem
    }
  }
}