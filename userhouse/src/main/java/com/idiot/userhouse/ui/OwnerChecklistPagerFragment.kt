package com.idiot.userhouse.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.idiot.userhouse.R
import com.idiot.userhouse.databinding.FragmentOwnerChecklistPagerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OwnerChecklistPagerFragment : Fragment() {

  private lateinit var binding : FragmentOwnerChecklistPagerBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_owner_checklist_pager, container, false)
    return binding.root
  }


}