package com.idiot.more.ui

import androidx.lifecycle.ViewModel
import com.idiot.data.repository.UserDeleteRepository
import com.idiot.data.repository.UserPreferenceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
  private val userPreferenceRepository: UserPreferenceRepository,
  private val userDeleteRepository: UserDeleteRepository
) : ViewModel() {

  fun deleteUser() = flow {
    val accessToken = userPreferenceRepository.getAccessToken().getOrNull().orEmpty()
    val deleteResult = userDeleteRepository.requestDeleteUser(accessToken)
    Timber.d("My Page ViewModel : $deleteResult")
    emit(MyPageEvent.UserDeleteSuccess)
  }
}

sealed class MyPageEvent {
  object UserDeleteSuccess : MyPageEvent()
}