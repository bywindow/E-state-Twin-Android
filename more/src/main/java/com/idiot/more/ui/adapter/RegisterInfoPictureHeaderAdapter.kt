package com.idiot.more.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.idiot.home.R
import com.idiot.home.databinding.ListItemRegisterInfoPictureHeaderBinding

class RegisterInfoPictureHeaderAdapter(
    private val onClick: () -> Unit
): RecyclerView.Adapter<RegisterInfoPictureHeaderAdapter.ViewHolder>() {

    class ViewHolder(
        binding: ListItemRegisterInfoPictureHeaderBinding, val onClick: () -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.setClickListener {
                Log.d("register", "add photo")
                onClick()
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
            ), onClick
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 1
    }

}