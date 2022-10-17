package com.idiot.more.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.idiot.more.R
import com.idiot.more.databinding.ListItemRegisterInfoPictureBinding
import com.idiot.model.RegisterEstatePicture

class RegisterInfoPictureAdapter(private val onClick: (RegisterEstatePicture) -> Unit) :
    ListAdapter<RegisterEstatePicture, RegisterInfoPictureAdapter.ViewHolder>(DiffCallback) {

    class ViewHolder(binding: ListItemRegisterInfoPictureBinding, val onClick: (RegisterEstatePicture) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {

        private val imageView: ImageView = binding.imageItemView
        private var currentItem: RegisterEstatePicture? = null

        init {
            binding.setClickListener {
                currentItem?.let {
                    onClick(currentItem!!)
                }
            }
        }

        fun bind(item: RegisterEstatePicture) {
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

object DiffCallback : DiffUtil.ItemCallback<RegisterEstatePicture>() {
    override fun areItemsTheSame(oldItem: RegisterEstatePicture, newItem: RegisterEstatePicture): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: RegisterEstatePicture, newItem: RegisterEstatePicture): Boolean {
        return oldItem.id == newItem.id
    }
}
