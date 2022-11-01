package com.idiot.more.ui

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.idiot.more.R
import com.idiot.more.databinding.FragmentMyPageBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber
import kotlin.system.exitProcess

@AndroidEntryPoint
class MyPageFragment : Fragment() {

  private lateinit var binding: FragmentMyPageBinding
  private val viewModel: MyPageViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    super.onCreateView(inflater, container, savedInstanceState)
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_page, container, false)

    subscribeUi()

    return binding.root
  }

  private fun subscribeUi() {
    binding.deleteUser.setClickListener {
      Timber.d("My Page View : request delete user")
      AlertDialog.Builder(requireActivity())
        .setTitle(R.string.user_delete_dialog_title)
        .setNegativeButton("취소", DialogInterface.OnClickListener { dialog, which ->
          dialog.cancel()
        })
        .setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->
          deleteUserButtonClicked()
        })
        .create().show()
    }
  }

  private fun deleteUserButtonClicked() {
    viewLifecycleOwner.lifecycleScope.launch {
      viewModel.deleteUser()
    }
    val packageManager = requireActivity().packageManager
    val intent = packageManager.getLaunchIntentForPackage(requireActivity().packageName)
    val componentName = intent?.component
    val mainIntent = Intent.makeRestartActivityTask(componentName)
    startActivity(mainIntent)
    exitProcess(0)
  }

}