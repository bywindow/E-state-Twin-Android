package com.idiot.userhouse.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.idiot.model.AssetIncludingChecklist
import com.idiot.userhouse.R
import com.idiot.userhouse.databinding.ListItemAssetListBinding
import com.idiot.userhouse.util.EnumToText
import timber.log.Timber

class AssetListAdapter(private val assetList: List<AssetIncludingChecklist>) :
  ListAdapter<AssetIncludingChecklist, AssetListAdapter.ViewHolder>(diffUtil) {

  inner class ViewHolder(private val binding: ListItemAssetListBinding) :
    RecyclerView.ViewHolder(binding.root) {

    init {
      binding.setClickListener { view ->
        val position = bindingAdapterPosition.takeIf { it != RecyclerView.NO_POSITION }
          ?: return@setClickListener
      navigateToCheckList(position)
      }
    }

    private fun navigateToCheckList(position: Int){
      Timber.d("navigate to check list $position")
    }

    fun bind(item: AssetIncludingChecklist) {
      binding.url = item.assetPhoto
      binding.assetName.text = EnumToText.bindAssetName(item.productName)
      binding.assetDate.text = if (item.checkLists != null && item.checkLists!!.isNotEmpty()) item.checkLists!!.last().repairDate else ""
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(
      DataBindingUtil.inflate(
        LayoutInflater.from(parent.context),
        R.layout.list_item_asset_list,
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