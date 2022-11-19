package com.idiot.userhouse.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.idiot.model.OwnerModeResponse
import com.idiot.userhouse.R
import com.idiot.userhouse.databinding.ListItemOwnerHouseBinding

class OwnerHouseAdapter() : ListAdapter<OwnerModeResponse, OwnerHouseAdapter.ViewHolder>(diffUtil) {

  inner class ViewHolder constructor(
    private val binding: ListItemOwnerHouseBinding
  ) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: OwnerModeResponse) {
      binding.model = item
      binding.setClickListener {
        navigateTo(item.estateId, it)
      }
    }

    private fun navigateTo(estateId: Long, view: View) {
      val direction = MyHouseFragmentDirections.actionMyHouseFragmentToOwnerChecklistPagerFragment(estateId)
      view.findNavController().navigate(direction)
    }

  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(
      DataBindingUtil.inflate(
        LayoutInflater.from(parent.context),
        R.layout.list_item_owner_house,
        parent,
        false
      )
    )
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(getItem(position))
  }

  companion object {
    private val diffUtil = object : DiffUtil.ItemCallback<OwnerModeResponse>() {
      override fun areItemsTheSame(
        oldItem: OwnerModeResponse,
        newItem: OwnerModeResponse
      ): Boolean {
        return oldItem.address == newItem.address
      }

      override fun areContentsTheSame(
        oldItem: OwnerModeResponse,
        newItem: OwnerModeResponse
      ): Boolean {
        return oldItem == newItem
      }
    }
  }
}