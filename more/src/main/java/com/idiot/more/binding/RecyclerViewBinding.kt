package com.idiot.more.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.idiot.model.AssetIncludingChecklist
import com.idiot.model.HouseOption

object RecyclerViewBinding {
  @JvmStatic
  @BindingAdapter("adapter", "submitList")
  fun bindAdapter(view: RecyclerView, adapter: ListAdapter<HouseOption, *>, itemList: List<HouseOption>) {
    view.adapter = adapter
    adapter.submitList(itemList.toMutableList())
  }

  @JvmStatic
  @BindingAdapter("assetAdapter", "submitAssetList")
  fun bindAssetAdapter(view: RecyclerView, adapter: ListAdapter<AssetIncludingChecklist, *>, itemList: List<AssetIncludingChecklist>) {
    view.adapter = adapter
    adapter.submitList(itemList)
  }
}