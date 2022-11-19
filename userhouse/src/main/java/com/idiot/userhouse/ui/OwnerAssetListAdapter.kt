package com.idiot.userhouse.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.idiot.model.AssetIncludingChecklist
import com.idiot.userhouse.R
import com.idiot.userhouse.databinding.ListItemOwnerAssetListBinding

class OwnerAssetListAdapter :
  ListAdapter<AssetIncludingChecklist, OwnerAssetListAdapter.ViewHolder>(diffUtil) {

  inner class ViewHolder(private val binding: ListItemOwnerAssetListBinding) :
    RecyclerView.ViewHolder(binding.root) {

    init {

    }

    fun bind(item: AssetIncludingChecklist) {
      binding.model = item
      if (item.checkLists?.isNotEmpty() == true) {
        binding.flawPartText.text = item.checkLists!!.last().flawPart
        binding.checklistDescText.text = item.checkLists!!.last().checkListContent
      }
    }

  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(
      DataBindingUtil.inflate(
        LayoutInflater.from(parent.context),
        R.layout.list_item_owner_asset_list,
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