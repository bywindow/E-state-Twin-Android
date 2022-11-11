package com.idiot.more.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.idiot.more.R
import com.idiot.more.databinding.FragmentRegisterCheckListBinding

class RegisterCheckListFragment : Fragment() {

  private lateinit var binding: FragmentRegisterCheckListBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register_check_list, container, false)
    binding.lifecycleOwner = this

    return binding.root
  }
}