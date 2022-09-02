package com.idiot.common_ui.home.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.idiot.common_ui.R
import com.idiot.common.home.viewmodels.UserRecommendViewModel
import com.idiot.common_ui.databinding.ListItemHomeRecommendBinding
import com.idiot.common_ui.home.HomeFragmentDirections
import com.idiot.data.api.RecommendedHouse

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
            binding.setChangeThumbnail {
                binding.viewModel?.isShowModel = !binding.viewModel?.isShowModel!!
                Log.d("HOUSEID", binding.viewModel?.isShowModel.toString())
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