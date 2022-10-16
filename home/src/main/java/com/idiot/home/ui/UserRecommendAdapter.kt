package com.idiot.home.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.idiot.model.RecommendedEstate
import com.idiot.home.R
import com.idiot.home.databinding.ListItemHomeRecommendBinding

class UserRecommendAdapter(private var recommendedList: List<RecommendedEstate>) :
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

    class ViewHolder(
        private val binding: ListItemHomeRecommendBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener { view ->

            }
            binding.setChangeThumbnail {


            }
        }

        private fun navigateToDetail(houseId: Long, view: View){
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