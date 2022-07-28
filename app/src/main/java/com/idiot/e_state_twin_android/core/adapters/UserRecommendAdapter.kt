package com.idiot.e_state_twin_android.core.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.idiot.e_state_twin_android.R
import com.idiot.e_state_twin_android.core.data.models.RecommendedHouse
import com.idiot.e_state_twin_android.core.ui.HomeFragmentDirections
import com.idiot.e_state_twin_android.core.viewmodels.UserRecommendViewModel
import com.idiot.e_state_twin_android.databinding.ListItemHomeRecommendBinding

class UserRecommendAdapter(private var recommendedList: List<RecommendedHouse>) :
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
                binding.viewModel?.recommendedHouse?.houseId?.let { houseId ->
                    Log.d("HOUSEID", houseId.toString())
                    navigateToDetail(houseId, view)
                }
            }
        }

        private fun navigateToDetail(houseId: Long, view: View){
            val direction = HomeFragmentDirections
                .actionHomeFragmentToHouseDetailFragment(houseId)
            view.findNavController().navigate(direction)
        }

        fun bind(recommend: RecommendedHouse) {
            with(binding) {
                viewModel = UserRecommendViewModel(recommend)
                executePendingBindings()
            }
        }
    }

    override fun getItemCount(): Int {
        return recommendedList.size
    }
}