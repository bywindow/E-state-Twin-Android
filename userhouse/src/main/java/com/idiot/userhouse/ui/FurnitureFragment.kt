package com.idiot.userhouse.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.idiot.userhouse.R
import com.idiot.userhouse.databinding.FragmentFurnitureBinding

class FurnitureFragment : Fragment() {

  private lateinit var binding: FragmentFurnitureBinding
  private val viewModel: OwnerChecklistViewModel by viewModels ({requireParentFragment()})

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_furniture, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    binding.apply {
      lifecycleOwner = this@FurnitureFragment
      adapter = OwnerAssetListAdapter()
      vm = viewModel
    }
  }


}