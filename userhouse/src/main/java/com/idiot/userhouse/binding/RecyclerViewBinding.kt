package com.idiot.userhouse.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.idiot.model.AssetIncludingChecklist

object RecyclerViewBinding {

  @JvmStatic
  @BindingAdapter("adapter", "submitList")
  fun bindAdapter(view: RecyclerView, adapter: ListAdapter<AssetIncludingChecklist, *>, itemList: List<AssetIncludingChecklist>) {
    view.adapter = adapter
    adapter.submitList(itemList)
  }
}