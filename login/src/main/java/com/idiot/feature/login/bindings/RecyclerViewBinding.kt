package com.idiot.feature.login.bindings

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.idiot.model.users.UserPreference

object RecyclerViewBinding {

  /**
   * 주소 리스트를 가져와 recyclerView에 adapter를 부착한다.
   */
  @JvmStatic
  @BindingAdapter("adapter", "submitList")
  fun bindAdapter(view: RecyclerView, adapter: ListAdapter<UserPreference, *>, itemList: List<UserPreference>) {
    view.adapter = adapter
    adapter.submitList(itemList.toMutableList())
  }
}
