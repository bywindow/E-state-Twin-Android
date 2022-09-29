package com.idiot.more.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.idiot.more.R
import com.idiot.more.databinding.ListItemRegisterOptionBinding
import com.idiot.model.HouseOption

class RegisterInfoOptionAdapter(private val onClick: (HouseOption) -> Unit)
    : ListAdapter<HouseOption, RegisterInfoOptionAdapter.ViewHolder>(RegisterOptionDiffCallback) {

    class ViewHolder(binding: ListItemRegisterOptionBinding, val onClick: (HouseOption) -> Unit)
        : RecyclerView.ViewHolder(binding.root) {

        private val optionButton = binding.registerOptionButton
        private val optionText = binding.registerOptionTextView
        private var currentItem: HouseOption? = null

        init {
            binding.setClickListener {
                currentItem?.let {
                    onClick(currentItem!!)
                }
            }
        }

        fun bind(item: HouseOption) {
            currentItem = item
            optionButton.setImageResource(item.icon)
            optionButton.background =
                if (item.hasOption) optionButton.context.getDrawable(R.drawable.register_option_button_active_rounded)
                else  optionButton.context.getDrawable(R.drawable.register_option_button_inactive_rounded)
            optionText.text = item.desc
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_register_option,
                parent,
                false
            ), onClick
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, payloads: MutableList<Any>) {
        if(payloads.isNotEmpty()) {

        } else {
            super.onBindViewHolder(holder, position, payloads)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

object RegisterOptionDiffCallback : DiffUtil.ItemCallback<HouseOption>() {
    override fun areItemsTheSame(oldItem: HouseOption, newItem: HouseOption): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: HouseOption, newItem: HouseOption): Boolean {
        return oldItem.id == newItem.id
    }
}