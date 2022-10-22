package com.idiot.more.ui

import android.Manifest
import android.app.Activity
import android.content.ClipData
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import com.google.android.material.snackbar.Snackbar
import com.idiot.model.HouseOption
import com.idiot.model.RegisterEstatePicture
import com.idiot.more.R
import com.idiot.more.databinding.FragmentRegisterInfoBinding
import com.idiot.more.ui.adapter.RegisterInfoOptionAdapter
import com.idiot.more.ui.adapter.RegisterInfoPictureAdapter
import com.idiot.more.ui.adapter.RegisterInfoPictureHeaderAdapter
import com.idiot.utils.NetworkStatus
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegisterInfoFragment : Fragment() {

  private lateinit var binding: FragmentRegisterInfoBinding
  private val viewModel by viewModels<RegisterInfoViewModel>()

  private val requestPermissionLauncher =
    registerForActivityResult(
      ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
      if (isGranted) {
        // 권한이 승인되어 있는 경우 : 갤러리에서 사진 선택
        navigateToPhoto()
      } else {
        Log.d("register", "Denied :(")
      }
    }

  private val selectImageResultLauncher: ActivityResultLauncher<Intent> =
    registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
      if (it.resultCode == Activity.RESULT_OK && it.data != null) {
        val mClipData: ClipData = it.data!!.clipData!!
        val images = mutableListOf<Uri>() // image uri, file path
        for (i in 0 until mClipData.itemCount) {
          val imageUri = mClipData.getItemAt(i).uri
          images.add(imageUri)
        }
        viewModel.insertPicture(images)
      }
    }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register_info, container, false)

    initNavigation()
    initAdapter()
    initAddressSearchDialogListener(binding)

    return binding.root
  }

  private fun initNavigation() {
//    toolbar.setNavigationIcon(R.drawable.ic_navigate_up)
//    toolbar.setNavigationOnClickListener {
//      it.findNavController().navigateUp()
//    }

    binding.homeInfoDialogButton.setOnClickListener {
      openBottomSheetDialog(it)
    }
    binding.priceInfoDialogButton.setOnClickListener {
      openBottomSheetDialog(it)
    }
    binding.registerArChecklistButton.setOnClickListener {
      startActivity(Intent(context, RegisterARActivity::class.java))
    }
  }

  private fun initAdapter() {
    val headerAdapter = RegisterInfoPictureHeaderAdapter { addPicture() }
    val pictureAdapter = RegisterInfoPictureAdapter { registerPicture ->
      viewModel.deletePicture(registerPicture)
    }
    val concatAdapter = ConcatAdapter(headerAdapter, pictureAdapter)
    binding.estatePictureRecyclerview.adapter = concatAdapter

    viewModel.pictureList.observe(viewLifecycleOwner) {
      it?.let {
        pictureAdapter.submitList(it as MutableList<RegisterEstatePicture>)
        updatePictureCount(it)
      }
    }

    val optionAdapter = RegisterInfoOptionAdapter { houseOption -> viewModel.changeOptionStatus(houseOption) }
    binding.registerOptionRecyclerView.adapter = optionAdapter

    viewModel.optionList.observe(viewLifecycleOwner) {
      it?.let {
        optionAdapter.submitList(it.values.toList() as MutableList<HouseOption>)
        optionAdapter.notifyDataSetChanged()
      }
    }
  }

  private fun addPicture() {
    when {
      ContextCompat.checkSelfPermission(
        requireContext(),
        Manifest.permission.READ_EXTERNAL_STORAGE
      ) == PackageManager.PERMISSION_GRANTED -> {
        // 권한이 승인되어 있는 경우 : 갤러리에서 사진 선택
        navigateToPhoto()
      }
      shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE) -> {
        // Educated 화면을 보여준 후 권한 요청
        showPermissionContextPopup()
      }
      else -> {
        requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
      }
    }
  }

  private fun showPermissionContextPopup() {
    AlertDialog.Builder(requireContext())
      .setTitle("권한 요청")
      .setMessage("사진을 추가하기 위해 권한 요청에 동의해주세요.")
      .setPositiveButton("확인") { _, _ ->
        requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
      }
      .setNegativeButton("취소") { _, _ -> }
      .create()
      .show()
  }

  private fun navigateToPhoto() {
    val intent = Intent(Intent.ACTION_PICK)
    intent.data = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
    intent.type = "image/*"
    intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
    selectImageResultLauncher.launch(intent)
  }

  private fun updatePictureCount(list: List<RegisterEstatePicture>) {
    binding.pictureCountTextView.text = "${list.size}/${getString(R.string.picture_max_count)}"
  }

  private fun initAddressSearchDialogListener(binding: FragmentRegisterInfoBinding) {
    binding.addressSearchEditText.setOnClickListener {
      val networkStatus = NetworkStatus()
      if (networkStatus.isNetworkAvailable(requireContext())) {
        val direction =
          RegisterInfoFragmentDirections.actionRegisterInfoFragmentToAddressSearchDialogFragment()
        it.findNavController().navigate(direction)
      } else {
        Snackbar.make(binding.root, "인터넷 연결을 확인해주세요.", Snackbar.LENGTH_SHORT).show()
      }
    }
  }

  private fun openBottomSheetDialog(view: View) {
    when (view.id) {
      R.id.home_info_dialog_button -> {
        val direction = RegisterInfoFragmentDirections
          .actionRegisterInfoFragmentToRegisterHouseInfoFragment()
        view.findNavController().navigate(direction)
      }
      R.id.price_info_dialog_button -> {
        //TODO : Add input price page
        Log.d("register", "price info")
      }
      else -> return
    }
  }

  private fun registerCompleteButtonClicked() {
    binding.registerCompleteButton.setOnClickListener {
      lifecycleScope.launch {

      }
    }
  }
}