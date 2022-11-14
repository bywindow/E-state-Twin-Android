package com.idiot.more.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.idiot.more.R
import com.idiot.more.databinding.FragmentEditChecklistBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class EditChecklistFragment : Fragment() {

  private lateinit var binding: FragmentEditChecklistBinding
  private val viewModel: EditChecklistViewModel by viewModels()
  private val args: EditChecklistFragmentArgs by navArgs()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate<FragmentEditChecklistBinding?>(
      inflater,
      R.layout.fragment_edit_checklist,
      container,
      false
    ).apply {
      lifecycleOwner = this@EditChecklistFragment
      vm = viewModel
    }
    viewModel.initChecklistInfo(args.checklist)
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
    binding.completeButton.setOnClickListener {
      viewLifecycleOwner.lifecycleScope.launch {
        viewModel.saveInputField(
          manufacturer = binding.manufacturerEditText.text.toString(),
          productName = binding.productNameEditText.text.toString(),
          flawPart = binding.flawPartEditText.text.toString(),
          description = binding.descriptionEditText.text.toString(),
          repairDate = "2022-11-12",
          estateId = args.estateId
        ).collect(){
          when (it) {
            is CheckListStatus.CheckListPostingSuccess -> {
              Timber.d("success : ${it.response}")
              findNavController().navigateUp()
            }
            is CheckListStatus.CheckListPostingFailed -> {
              Toast.makeText(requireContext(), "다시 시도해주세요.", Toast.LENGTH_SHORT).show()
            }
          }
        }
      }
    }
  }

}