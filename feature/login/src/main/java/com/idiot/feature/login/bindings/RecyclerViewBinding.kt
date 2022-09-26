package com.idiot.feature.login.bindings

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.idiot.model.PreferenceCity

object RecyclerViewBinding {

  /**
   * 주소 리스트를 가져와 recyclerView에 adapter를 부착한다.
   */
  @JvmStatic
  @BindingAdapter("adapter", "submitList")
  fun bindAdapter(view: RecyclerView, adapter: ListAdapter<String, *>, itemList: Array<String>) {
    view.adapter = adapter
    val list: List<String> = itemList.toList()
    adapter.submitList(list.toMutableList())
  }
}
