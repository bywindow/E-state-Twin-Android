package com.idiot.more.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.idiot.more.R
import com.idiot.more.databinding.ListItemNewRegisterBinding
import com.idiot.data.repository.samples.inquiryInfo
import com.idiot.model.EstateListBrokerResponse
import com.idiot.more.ui.RegisterFragmentDirections

class RegisterNewInquiryAdapter(
  private val inquiry: List<EstateListBrokerResponse>,
  private val isInquired: Boolean
) :
  RecyclerView.Adapter<RegisterNewInquiryAdapter.ViewHolder>() {
  inner class ViewHolder constructor(
    private val binding: ListItemNewRegisterBinding
  ) : RecyclerView.ViewHolder(binding.root) {
    init {
      binding.setClickListener { view ->
        val position = bindingAdapterPosition.takeIf { it != RecyclerView.NO_POSITION }
          ?: return@setClickListener
        navigateTo(inquiry[position].estateId, view)
      }
    }

    fun bind(item: EstateListBrokerResponse) {
      binding.houseNameTextView.text = item.estateAddress.buildingName
      binding.houseAddrTextView.text =
        "${item.estateAddress.city} ${item.estateAddress.borough} ${item.estateAddress.roadName}"
      binding.houseOwnerNameTextView.text = item.ownerName
      binding.houseOwnerPhoneTextView.text = item.ownerPhone
      binding.executePendingBindings()
    }

    private fun navigateTo(estateId: Long, view: View) {
      val direction =
        if (isInquired) RegisterFragmentDirections.actionRegisterFragmentToRegisterCheckListFragment(estateId)
        else RegisterFragmentDirections.actionRegisterFragmentToRegisterInfoFragment(estateId)
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
    holder.bind(inquiry[position])
  }

  override fun getItemCount(): Int = inquiry.size
}