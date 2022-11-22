package com.idiot.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.idiot.home.R
import com.idiot.home.databinding.FragmentEstateListBinding


class EstateListFragment : Fragment() {

  private lateinit var binding: FragmentEstateListBinding
  private val args: EstateListFragmentArgs by navArgs()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_estate_list, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    binding.apply {
      lifecycleOwner = this@EstateListFragment
      title = "${args.borough} 추천매물"
    }
  }

}