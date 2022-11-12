package com.idiot.more.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.idiot.more.R
import com.idiot.more.databinding.FragmentContractingBinding

class ContractingFragment : Fragment() {

  private lateinit var binding: FragmentContractingBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_contracting, container, false)
    binding.lifecycleOwner = this
    return binding.root
  }

}