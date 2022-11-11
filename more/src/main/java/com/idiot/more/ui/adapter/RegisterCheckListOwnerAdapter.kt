package com.idiot.more.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.idiot.model.AssetIncludingChecklist
import com.idiot.more.databinding.ListItemCheckListOwnerBinding

class RegisterCheckListOwnerAdapter() : ListAdapter<AssetIncludingChecklist, RegisterCheckListOwnerAdapter.ViewHolder>(diffUtil) {

  inner class ViewHolder(private val binding: ListItemCheckListOwnerBinding): RecyclerView.ViewHolder(binding.root) {

  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    TODO("Not yet implemented")
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    TODO("Not yet implemented")
  }

  companion object {
    private val diffUtil = object : DiffUtil.ItemCallback<AssetIncludingChecklist>() {
      override fun areItemsTheSame(
        oldItem: AssetIncludingChecklist,
        newItem: AssetIncludingChecklist
      ): Boolean {
        return oldItem.id == newItem.id
      }

      override fun areContentsTheSame(
        oldItem: AssetIncludingChecklist,
        newItem: AssetIncludingChecklist
      ): Boolean {
        return oldItem == newItem
      }
    }
  }
}