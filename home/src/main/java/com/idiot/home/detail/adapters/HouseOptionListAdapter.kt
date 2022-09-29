package com.idiot.home.detail.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.idiot.home.R
import com.idiot.model.HouseOption

class HouseOptionListAdapter(private val optionList: List<HouseOption>) :
    RecyclerView.Adapter<HouseOptionListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item_detail_option,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.optionImage.setImageResource(optionList[position].icon)
        holder.optionText.text = optionList[position].desc
    }

    override fun getItemCount(): Int {
        return optionList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val optionImage: ImageView = itemView.findViewById(R.id.option_imageView)
        val optionText: TextView = itemView.findViewById(R.id.option_textView)
        // TODO INIT

    }
}


//
//override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//    return ViewHolder(
//        DataBindingUtil.inflate(
//            LayoutInflater.from(parent.context),
//            R.layout.list_item_detail_option,
//            parent,
//            false
//        )
//    )
//}
//
//override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//    holder.bind(optionList[position])
//}
//
//override fun getItemCount(): Int {
//    return optionList.size
//}
//
//class ViewHolder(
//    private val binding: ListItemDetailOptionBinding
//) : RecyclerView.ViewHolder(binding.root) {
//    // TODO INIT
//
//    fun bind(optionItem: OptionItem){
//        with(binding) {
//            viewmodel = HouseOptionViewModel(optionItem)
//            executePendingBindings()
//        }
//    }
//}