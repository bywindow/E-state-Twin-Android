package com.idiot.home.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.idiot.home.R
import com.idiot.home.databinding.ListItemHomeRecommendBinding
import com.idiot.home.util.EnumToText
import com.idiot.model.RecommendedEstate
import timber.log.Timber

class UserRecommendAdapter(private val recommendedList: List<RecommendedEstate>) :
  ListAdapter<RecommendedEstate, UserRecommendAdapter.ViewHolder>(diffUtil) {

  inner class ViewHolder(
    private val binding: ListItemHomeRecommendBinding
  ) : RecyclerView.ViewHolder(binding.root) {

    init {
      binding.setClickListener { view ->
        val position = bindingAdapterPosition.takeIf { it != RecyclerView.NO_POSITION }
          ?: return@setClickListener
        navigateToDetail(recommendedList[position].id, view)
      }
      binding.setChangeThumbnail {
        Timber.d("CHANGE ${recommendedList}")
      }
    }

    private fun navigateToDetail(houseId: Long, view: View) {
      val direction = HomeFragmentDirections
        .actionHomeFragmentToHouseDetailFragment(houseId)
      view.findNavController().navigate(direction)
    }

    fun bind(item: RecommendedEstate) {
      binding.estateType.text = EnumToText.changeTransactionType(item.transactionType)
      binding.housePrice.text = item.sellingFee.toString()
      binding.houseType.text = EnumToText.changeEstateType(item.estateType)
      binding.houseAddress.text = item.town
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(
      DataBindingUtil.inflate(
        LayoutInflater.from(parent.context),
        R.layout.list_item_home_recommend,
        parent,
        false
      )
    )
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(getItem(position))
  }

  companion object {
    private val diffUtil = object : DiffUtil.ItemCallback<RecommendedEstate>() {
      override fun areItemsTheSame(oldItem: RecommendedEstate, newItem: RecommendedEstate): Boolean {
        return oldItem.id == newItem.id
      }

      override fun areContentsTheSame(oldItem: RecommendedEstate, newItem: RecommendedEstate): Boolean {
        return oldItem == newItem
      }

    }
  }
}