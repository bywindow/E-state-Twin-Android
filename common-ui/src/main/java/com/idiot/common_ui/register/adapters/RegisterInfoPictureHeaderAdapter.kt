package com.idiot.common_ui.register.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.idiot.common_ui.R
import com.idiot.common_ui.databinding.ListItemRegisterInfoPictureHeaderBinding

class RegisterInfoPictureHeaderAdapter: RecyclerView.Adapter<RegisterInfoPictureHeaderAdapter.ViewHolder>() {

    class ViewHolder(
        binding: ListItemRegisterInfoPictureHeaderBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.setClickListener {
                Log.d("register", "add photo")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_register_info_picture_header,
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 1
    }
}