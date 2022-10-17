package com.idiot.more.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idiot.data.repository.EstateImageS3UploadRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

class RegisterInfoViewModel(private val s3UploadRepository: EstateImageS3UploadRepository) : ViewModel() {



//  fun requestImageS3Uri() {
//    viewModelScope.launch {
//      val response = s3UploadRepository.requestImageUri()
//    }
//  }
}