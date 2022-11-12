package com.idiot.more.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.NO_POSITION
import com.idiot.model.AssetIncludingChecklist
import com.idiot.more.R
import com.idiot.more.databinding.ListItemCheckListOwnerBinding
import com.idiot.more.util.MappingToEnumUtil
import timber.log.Timber

class RegisterCheckListOwnerAdapter() :
  ListAdapter<AssetIncludingChecklist, RegisterCheckListOwnerAdapter.ViewHolder>(diffUtil) {

  inner class ViewHolder(private val binding: ListItemCheckListOwnerBinding) :
    RecyclerView.ViewHolder(binding.root) {

    init {
      binding.setClickListener {
        val position =
          bindingAdapterPosition.takeIf { it != NO_POSITION } ?: return@setClickListener
        Timber.d("checklist : $position")
      }
    }

    fun bind(item: AssetIncludingChecklist) {
      binding.model = item
      binding.categoryText.text = MappingToEnumUtil.assetCategoryToKor(item.category)
      binding.optionText.text = MappingToEnumUtil.assetOptionToKor(item.option)
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(
      DataBindingUtil.inflate(
        LayoutInflater.from(parent.context),
        R.layout.list_item_check_list_owner,
        parent,
        false
      )
    )
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(getItem(position))
  }

  companion object {
    private val diffUtil = object : DiffUtil.ItemCallback<AssetIncludingChecklist>() {
      override fun areItemsTheSame(
        oldItem: AssetIncludingChecklist,
        newItem: AssetIncludingChecklist
      ): Boolean {
        return oldItem.id == newItem.id
      }

      override fun areContentsTheSame(
        oldItem: AssetIncludingChecklist,
        newItem: AssetIncludingChecklist
      ): Boolean {
        return oldItem == newItem
      }
    }
  }
}