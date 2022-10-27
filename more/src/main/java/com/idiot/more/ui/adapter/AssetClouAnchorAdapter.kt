package com.idiot.more.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.NO_POSITION
import com.idiot.model.HouseOption
import com.idiot.more.R
import com.idiot.more.databinding.ListItemAssetArBinding

class AssetCloudAnchorAdapter(private val onClick: (Int) -> Unit) :
  ListAdapter<HouseOption, AssetCloudAnchorAdapter.ViewHolder>(diffUtil) {

  private var selectedAsset: Int = 0

  inner class ViewHolder(private val binding: ListItemAssetArBinding, val onClick: (Int) -> Unit) :
    RecyclerView.ViewHolder(binding.root) {

    init {
      selectedAsset = 0
      binding.root.setOnClickListener {
        val position = bindingAdapterPosition.takeIf { it != NO_POSITION } ?: return@setOnClickListener
        onClick(position)
        if (selectedAsset != absoluteAdapterPosition) {
          binding.setCheck()
          notifyItemChanged(selectedAsset)
          selectedAsset = absoluteAdapterPosition
        }
      }
    }

    fun bind(item: HouseOption) {
      binding.assetImageView.setImageResource(item.icon)
      binding.assetTextView.text = item.desc
      if (selectedAsset == absoluteAdapterPosition) {
        binding.setCheck()
      } else {
        binding.setUnchecked()
      }
      binding.executePendingBindings()
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(
      DataBindingUtil.inflate(
        LayoutInflater.from(parent.context),
        R.layout.list_item_asset_ar,
        parent,
        false
      ), onClick
    )
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int, payloads: MutableList<Any>) {
    if (payloads.isEmpty()) super.onBindViewHolder(holder, position, payloads)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(getItem(position))
  }

  private fun ListItemAssetArBinding.setCheck() {
    assetItemLayout.setBackgroundResource(R.drawable.bg_ar_asset_rounded_active)
//    assetItemLayout.context.getDrawable(R.drawable.bg_ar_asset_rounded_active)
  }

  private fun ListItemAssetArBinding.setUnchecked() {
    assetItemLayout.setBackgroundResource(R.drawable.bg_ar_asset_rounded_inactive)
//    assetItemLayout.context.getDrawable(R.drawable.bg_ar_asset_rounded_inactive)
  }

  companion object {
    private val diffUtil = object : DiffUtil.ItemCallback<HouseOption>() {
      override fun areItemsTheSame(oldItem: HouseOption, newItem: HouseOption): Boolean {
        return oldItem.hasOption == newItem.hasOption
      }

      override fun areContentsTheSame(oldItem: HouseOption, newItem: HouseOption): Boolean {
        return oldItem == newItem
      }
    }
  }
}