package com.idiot.more.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.idiot.model.HouseOption

object RecyclerViewBinding {
  @JvmStatic
  @BindingAdapter("adapter", "submitList")
  fun bindAdapter(view: RecyclerView, adapter: ListAdapter<Pair<Int, HouseOption>, *>, itemList: Map<Int, HouseOption>) {
    view.adapter = adapter
    adapter.submitList(itemList.toList().toMutableList())
  }
}