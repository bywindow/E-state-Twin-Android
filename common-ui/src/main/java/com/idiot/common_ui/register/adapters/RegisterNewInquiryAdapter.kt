package com.idiot.common_ui.register.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.idiot.common_ui.R
import com.idiot.common_ui.databinding.ListItemNewRegisterBinding
import com.idiot.common_ui.register.RegisterFragmentDirections
import com.idiot.data.repository.samples.inquiryInfo

class RegisterNewInquiryAdapter(private val inquiry : List<inquiryInfo>) : RecyclerView.Adapter<RegisterNewInquiryAdapter.ViewHolder>() {
    class ViewHolder(
        private val binding: ListItemNewRegisterBinding
    ) : RecyclerView.ViewHolder(binding.root){
        init {
            binding.setClickListener { view ->
                navigateTo(0, view)
            }
        }

        fun bind(item: inquiryInfo, position: Int) {
            binding.houseNameTextView.text = "${item.name} $position"
            binding.houseAddrTextView.text = "${item.address} $position"
            binding.houseOwnerNameTextView.text = "${item.ownerName} $position"
            binding.houseOwnerPhoneTextView.text = "${item.ownerPhone} $position"
        }

        private fun navigateTo(estateId: Long, view: View) {
            val direction = RegisterFragmentDirections.actionRegisterFragmentToRegisterInfoFragment(estateId)
            view.findNavController().navigate(direction)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_new_register,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(inquiry[position], position)
    }

    override fun getItemCount(): Int = inquiry.size
}