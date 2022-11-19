package com.idiot.userhouse.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.idiot.model.OwnerModeResponse
import com.idiot.userhouse.R
import com.idiot.userhouse.databinding.ListItemOwnerHouseBinding

class OwnerHouseAdapter() : ListAdapter<OwnerModeResponse, OwnerHouseAdapter.ViewHolder>(diffUtil) {

  inner class ViewHolder constructor(
    private val binding: ListItemOwnerHouseBinding
  ) : RecyclerView.ViewHolder(binding.root) {
    init {
      binding.setClickListener { view ->
        val position = bindingAdapterPosition.takeIf { it != RecyclerView.NO_POSITION } ?: return@setClickListener

      }
    }

    fun bind(item: OwnerModeResponse) {
      binding.model = item
    }

  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(
      DataBindingUtil.inflate(
        LayoutInflater.from(parent.context),
        R.layout.list_item_owner_house,
        parent,
        false
      )
    )
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(getItem(position))
  }

  companion object {
    private val diffUtil = object : DiffUtil.ItemCallback<OwnerModeResponse>() {
      override fun areItemsTheSame(
        oldItem: OwnerModeResponse,
        newItem: OwnerModeResponse
      ): Boolean {
        return oldItem.address == newItem.address
      }

      override fun areContentsTheSame(
        oldItem: OwnerModeResponse,
        newItem: OwnerModeResponse
      ): Boolean {
        return oldItem == newItem
      }
    }
  }
}