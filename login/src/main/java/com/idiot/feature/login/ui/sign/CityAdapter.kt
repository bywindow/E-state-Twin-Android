package com.idiot.feature.login.ui.sign

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.NO_POSITION
import com.idiot.feature.login.R
import com.idiot.feature.login.databinding.ListItemCitiesBinding
import com.idiot.model.users.UserPreference

class CityAdapter(private val onClick: (Int) -> Unit) :
  ListAdapter<UserPreference, CityAdapter.ViewHolder>(diffUtil) {

  private var selectedPosition: Int = 0

  inner class ViewHolder(private val binding: ListItemCitiesBinding, val onClick: (Int) -> Unit) :
    RecyclerView.ViewHolder(binding.root) {

    init {
      binding.root.setOnClickListener {
        val position = bindingAdapterPosition.takeIf { it != NO_POSITION } ?: return@setOnClickListener
        onClick(position)
        if (selectedPosition != absoluteAdapterPosition) {
          binding.setChecked()
          notifyItemChanged(selectedPosition)
          selectedPosition = absoluteAdapterPosition
        }
      }
    }

    fun bind(item: UserPreference) {
      binding.model = item
      if (selectedPosition == absoluteAdapterPosition) {
        binding.setChecked()
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
        R.layout.list_item_cities,
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

  private fun ListItemCitiesBinding.setChecked() {
    citiesTextView.setTextColor(Color.BLACK)
    citiesTextView.setBackgroundColor(Color.WHITE)
  }

  private fun ListItemCitiesBinding.setUnchecked() {
    citiesTextView.setBackgroundColor(Color.LTGRAY)
    citiesTextView.setTextColor(Color.DKGRAY)
  }

  companion object {
    private val diffUtil = object : DiffUtil.ItemCallback<UserPreference>() {
      override fun areItemsTheSame(oldItem: UserPreference, newItem: UserPreference): Boolean =
        oldItem.id == newItem.id

      override fun areContentsTheSame(oldItem: UserPreference, newItem: UserPreference): Boolean =
        oldItem == newItem
    }
  }
}