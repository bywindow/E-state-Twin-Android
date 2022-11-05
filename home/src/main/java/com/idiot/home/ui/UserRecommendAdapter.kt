package com.idiot.home.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.idiot.home.R
import com.idiot.home.databinding.ListItemHomeRecommendBinding
import com.idiot.model.RecommendedEstate

class UserRecommendAdapter(private val recommendedList: List<RecommendedEstate>) :
  RecyclerView.Adapter<UserRecommendAdapter.ViewHolder>() {

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
    holder.bind(recommendedList[position])
  }

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

      }
    }

    private fun navigateToDetail(houseId: Int, view: View) {
      val direction = HomeFragmentDirections
        .actionHomeFragmentToHouseDetailFragment(houseId)
      view.findNavController().navigate(direction)
    }

    fun bind(recommend: RecommendedEstate) {
      with(binding) {
        executePendingBindings()
      }
    }
  }

  override fun getItemCount(): Int {
    return recommendedList.size
  }
}