package com.idiot.userhouse.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.idiot.model.AssetIncludingChecklist
import com.idiot.model.OwnerModeResponse

object RecyclerViewBinding {

  @JvmStatic
  @BindingAdapter("adapter", "submitList")
  fun bindAdapter(view: RecyclerView, adapter: ListAdapter<AssetIncludingChecklist, *>, itemList: List<AssetIncludingChecklist>) {
    view.adapter = adapter
    adapter.submitList(itemList)
  }

  @JvmStatic
  @BindingAdapter("ownerAdapter", "submitList")
  fun bindOwnerAdapter(view: RecyclerView, adapter: ListAdapter<OwnerModeResponse, *>, itemList: List<OwnerModeResponse>) {
    view.adapter = adapter
    adapter.submitList(itemList)
  }
}