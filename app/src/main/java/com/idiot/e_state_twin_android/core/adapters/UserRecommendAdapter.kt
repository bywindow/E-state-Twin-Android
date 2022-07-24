package com.idiot.e_state_twin_android.core.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.idiot.e_state_twin_android.R
import com.idiot.e_state_twin_android.core.data.models.RecommendedHouse
import com.idiot.e_state_twin_android.core.viewmodels.UserRecommendViewModel
import com.idiot.e_state_twin_android.databinding.ListItemHomeRecommendBinding

class UserRecommendAdapter :
    ListAdapter<RecommendedHouse, UserRecommendAdapter.ViewHolder>(
        UserRecommendDiffCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
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
        TODO("Not yet implemented")
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ListItemHomeRecommendBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener { view ->
                binding.viewModel?.houseId?.let { houseId ->
                    Log.d("HOUSEID", houseId.toString())
                }
            }
        }

        fun bind(recommend: RecommendedHouse) {
            with(binding) {
                viewModel = UserRecommendViewModel(recommend)
                executePendingBindings()
            }
        }
    }
}

private class UserRecommendDiffCallback: DiffUtil.ItemCallback<RecommendedHouse>() {
    override fun areItemsTheSame(oldItem: RecommendedHouse, newItem: RecommendedHouse): Boolean {
        TODO("Not yet implemented")
    }

    override fun areContentsTheSame(oldItem: RecommendedHouse, newItem: RecommendedHouse): Boolean {
        TODO("Not yet implemented")
    }
}