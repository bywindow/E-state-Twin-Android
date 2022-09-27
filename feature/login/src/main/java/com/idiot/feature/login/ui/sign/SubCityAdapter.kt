package com.idiot.feature.login.ui.sign

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.NO_POSITION
import com.idiot.feature.login.R
import com.idiot.feature.login.databinding.ListItemDistinctBinding
import com.idiot.model.users.UserPreference

class SubCityAdapter(private val onClick: (Int) -> Unit) :
  ListAdapter<UserPreference, SubCityAdapter.ViewHolder>(diffUtil) {

  inner class ViewHolder(private val binding: ListItemDistinctBinding, val onClick: (Int) -> Unit) :
    RecyclerView.ViewHolder(binding.root) {

      init {
          binding.root.setOnClickListener {
            val position = bindingAdapterPosition.takeIf { it != NO_POSITION } ?: return@setOnClickListener
            onClick(position)
          }
      }

    fun bind(item: UserPreference) {
      binding.distinct = item.name
      binding.isSelected = item.isChecked
      binding.executePendingBindings()
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(
      DataBindingUtil.inflate(
        LayoutInflater.from(parent.context),
        R.layout.list_item_distinct,
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

  companion object {
    private val diffUtil = object : DiffUtil.ItemCallback<UserPreference>() {
      override fun areItemsTheSame(oldItem: UserPreference, newItem: UserPreference): Boolean {
        return oldItem.isChecked == newItem.isChecked
      }

      override fun areContentsTheSame(oldItem: UserPreference, newItem: UserPreference): Boolean {
        return oldItem == newItem
      }
    }
  }
}