package com.idiot.home.ui

import androidx.lifecycle.ViewModel
import com.idiot.data.repository.EstateSearchRepository
import com.idiot.model.EstateSearchResponse
import com.idiot.model.users.SearchByBorough
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class EstateListViewModel @Inject constructor(
  private val estateSearchRepository: EstateSearchRepository
) : ViewModel() {
  private val _estateList = MutableStateFlow(emptyList<EstateSearchResponse>())
  val estateList = _estateList.asStateFlow()

  fun fetchEstateList(borough: String) = flow {
    val data = SearchByBorough(borough = borough)
    val response = estateSearchRepository.requestEstateSearchList(data)
    _estateList.value = response
    emit(EstateListStatus.FetchSuccess)
  }
}

sealed class EstateListStatus {
  object FetchSuccess : EstateListStatus()
}