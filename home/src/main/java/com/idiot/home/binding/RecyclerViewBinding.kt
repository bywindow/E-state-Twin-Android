package com.idiot.home.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.idiot.model.AssetIncludingChecklist
import com.idiot.model.EstateSearchResponse
import com.idiot.model.HouseOption
import com.idiot.model.RecommendedEstate

object RecyclerViewBinding {

  @JvmStatic
  @BindingAdapter("adapter", "submitList")
  fun bindAdapter(view: RecyclerView, adapter: ListAdapter<AssetIncludingChecklist, *>, itemList: List<AssetIncludingChecklist>) {
    view.adapter = adapter
    adapter.submitList(itemList)
  }

  @JvmStatic
  @BindingAdapter("mainAdapter", "recommendList")
  fun bindMainAdapter(view: RecyclerView, adapter: ListAdapter<RecommendedEstate, *>, recommendList: List<RecommendedEstate>) {
    view.adapter = adapter
    adapter.submitList(recommendList)
  }

  @JvmStatic
  @BindingAdapter("estateAdapter", "estateList")
  fun bindEstateAdapter(view: RecyclerView, adapter: ListAdapter<EstateSearchResponse, *>, estateList: List<EstateSearchResponse>) {
    view.adapter = adapter
    adapter.submitList(estateList)
  }
}