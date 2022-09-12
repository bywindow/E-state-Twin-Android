package com.idiot.common_ui.register.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.idiot.common_ui.R
import com.idiot.common_ui.databinding.ListItemRegisterInfoPictureBinding
import com.idiot.model.RegisterPicture

class RegisterInfoPictureAdapter(private val onClick: (RegisterPicture) -> Unit) :
    ListAdapter<RegisterPicture, RegisterInfoPictureAdapter.ViewHolder>(DiffCallback) {

    class ViewHolder(binding: ListItemRegisterInfoPictureBinding, val onClick: (RegisterPicture) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {

        private val imageView: ImageView = binding.imageItemView
        private var currentItem: RegisterPicture? = null

        init {
            binding.setClickListener {
                currentItem?.let {
                    onClick(currentItem!!)
                }
            }
        }

        fun bind(item: RegisterPicture) {
            currentItem = item
            imageView.setImageURI(item.filePath)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_register_info_picture,
                parent,
                false
            ), onClick
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

object DiffCallback : DiffUtil.ItemCallback<RegisterPicture>() {
    override fun areItemsTheSame(oldItem: RegisterPicture, newItem: RegisterPicture): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: RegisterPicture, newItem: RegisterPicture): Boolean {
        return oldItem.id == newItem.id
    }
}
