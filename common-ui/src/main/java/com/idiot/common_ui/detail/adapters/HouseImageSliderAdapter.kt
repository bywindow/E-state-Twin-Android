package com.idiot.common_ui.detail.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.idiot.common_ui.R
import com.idiot.common_ui.databinding.SlideImageHouseDetailBinding

class HouseImageSliderAdapter(private var houseImage: List<String>) :
    RecyclerView.Adapter<HouseImageSliderAdapter.ViewHolder>() {

    class ViewHolder(
        private val binding: SlideImageHouseDetailBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(holder: ViewHolder, imageUrl: String) {
            Glide.with(holder.itemView)
                .load(imageUrl)
                .into(holder.itemView.findViewById(R.id.imageContainer))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.slide_image_house_detail,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(holder, houseImage[position])
    }

    override fun getItemCount(): Int {
        return houseImage.size
    }
}