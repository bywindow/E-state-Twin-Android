package com.idiot.common_ui.myhouse.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.idiot.common_ui.R
import com.idiot.common_ui.databinding.ListItemOwnerHouseBinding
import com.idiot.data.repository.samples.info

class OwnerHouseAdapter(private val houses: List<info>) : RecyclerView.Adapter<OwnerHouseAdapter.ViewHolder>() {

    class ViewHolder(
        private val binding: ListItemOwnerHouseBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.setClickListener {
                Log.d("HOUSEID", it.toString())
            }
        }

        fun bind(item: info, position: Int) {
            binding.myHouseTypeTextView.text = "${item.type} $position"
            binding.myHouseNameTextView.text = "${item.name} $position"
            binding.myHouseAddrTextView.text = "${item.address} $position"
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
        holder.bind(houses[position], position)
    }

    override fun getItemCount(): Int = houses.size
}