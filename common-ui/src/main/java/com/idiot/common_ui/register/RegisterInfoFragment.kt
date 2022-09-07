package com.idiot.common_ui.register

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import com.google.android.material.appbar.MaterialToolbar
import com.idiot.common_ui.R
import com.idiot.common_ui.databinding.FragmentRegisterInfoBinding
import com.idiot.common_ui.register.adapters.RegisterInfoPictureAdapter
import com.idiot.common_ui.register.adapters.RegisterInfoPictureHeaderAdapter
import com.idiot.model.register.RegisterPicture

class RegisterInfoFragment : Fragment() {

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()
        ) {isGranted: Boolean ->
            if (isGranted) {
                // 권한이 승인되어 있는 경우 : 갤러리에서 사진 선택
                Log.d("register", "Granted !")
            } else {
                Log.d("register", "Denied :(")
            }
        }

    private lateinit var binding: FragmentRegisterInfoBinding
    private lateinit var toolbar: MaterialToolbar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register_info, container, false)
        toolbar = binding.toolbarRegisterInfo.toolbar

        initNavigation()
        initAdapter()

        return binding.root
    }

    private fun initNavigation() {
        toolbar.setNavigationIcon(R.drawable.ic_navigate_up)
        toolbar.setNavigationOnClickListener {
            it.findNavController().navigateUp()
        }
    }

    private fun initAdapter() {
        val headerAdapter = RegisterInfoPictureHeaderAdapter { addPicture() }
        val pictureAdapter = RegisterInfoPictureAdapter { registerPicture -> deletePicture(registerPicture) }
        val concatAdapter = ConcatAdapter(headerAdapter, pictureAdapter)
        binding.estatePictureRecyclerview.adapter = concatAdapter
    }

    private fun deletePicture(item: RegisterPicture) {
        Log.d("register", "delete! $item")
    }

    private fun addPicture() {
        when {
            ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED -> {
                // 권한이 승인되어 있는 경우 : 갤러리에서 사진 선택
            }
            shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE) -> {
                // Educated 화면을 보여준 후 권한 요청
            }
            else -> {
                requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
            }
        }
    }

}