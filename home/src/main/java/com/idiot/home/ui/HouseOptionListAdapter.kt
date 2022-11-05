package com.idiot.home.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.idiot.home.R
import com.idiot.home.databinding.ListItemDetailOptionBinding
import com.idiot.model.AssetIncludingChecklist

class HouseOptionListAdapter() :
  ListAdapter<AssetIncludingChecklist, HouseOptionListAdapter.ViewHolder>(diffUtil) {

  inner class ViewHolder(
    private val binding: ListItemDetailOptionBinding
  ): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: AssetIncludingChecklist) {
      binding.model = item
      binding.executePendingBindings()
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(
      DataBindingUtil.inflate(
        LayoutInflater.from(parent.context),
        R.layout.list_item_detail_option,
        parent,
        false
      )
    )
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(getItem(position))
  }

  companion object {
    private val diffUtil = object : DiffUtil.ItemCallback<AssetIncludingChecklist>() {
      override fun areItemsTheSame(oldItem: AssetIncludingChecklist, newItem: AssetIncludingChecklist): Boolean {
        return oldItem.id == newItem.id
      }

      override fun areContentsTheSame(oldItem: AssetIncludingChecklist, newItem: AssetIncludingChecklist): Boolean {
        return oldItem == newItem
      }
    }
  }
}