package com.idiot.home.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.idiot.home.R
import com.idiot.home.databinding.ListItemEstateBinding
import com.idiot.model.EstateSearchResponse

class EstateListAdapter(private val town: String) :
  ListAdapter<EstateSearchResponse, EstateListAdapter.ViewHolder>(diffUtil) {

  inner class ViewHolder(
    private val binding: ListItemEstateBinding
  ) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: EstateSearchResponse) {
      binding.model = item
      binding.town = town
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(
      DataBindingUtil.inflate(
        LayoutInflater.from(parent.context),
        R.layout.list_item_estate,
        parent,
        false
      )
    )
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(getItem(position))
  }

  companion object {
    private val diffUtil = object : DiffUtil.ItemCallback<EstateSearchResponse>() {
      override fun areItemsTheSame(
        oldItem: EstateSearchResponse,
        newItem: EstateSearchResponse
      ): Boolean {
        return oldItem.id == newItem.id
      }

      override fun areContentsTheSame(
        oldItem: EstateSearchResponse,
        newItem: EstateSearchResponse
      ): Boolean {
        return oldItem == newItem
      }

    }
  }
}