package com.idiot.home.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.idiot.model.AssetIncludingChecklist
import com.idiot.model.HouseOption

object RecyclerViewBinding {

  @JvmStatic
  @BindingAdapter("adapter", "submitList")
  fun bindAdapter(view: RecyclerView, adapter: ListAdapter<AssetIncludingChecklist, *>, itemList: List<AssetIncludingChecklist>) {
    view.adapter = adapter
    adapter.submitList(itemList)
  }
}