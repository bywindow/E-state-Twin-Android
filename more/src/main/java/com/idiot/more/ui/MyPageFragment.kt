package com.idiot.more.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.idiot.more.R
import com.idiot.more.databinding.FragmentMyPageBinding

class MyPageFragment : Fragment() {

  lateinit var binding: FragmentMyPageBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    super.onCreateView(inflater, container, savedInstanceState)
    binding = DataBindingUtil.inflate(
      inflater, R.layout.fragment_my_page, container, false
    )

    return binding.root
  }

}