package com.idiot.more.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.idiot.more.R
import com.idiot.more.databinding.FragmentEditChecklistBinding

class EditChecklistFragment : Fragment() {

  private lateinit var binding: FragmentEditChecklistBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_checklist, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    subscribeUI()
  }

  private fun subscribeUI() {
    binding.closeButton.setOnClickListener {
      findNavController().navigateUp()
    }
    binding.toolbarEditChecklist.appBar.elevation = 4.0f
  }

}