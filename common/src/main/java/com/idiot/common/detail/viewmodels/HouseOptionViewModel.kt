package com.idiot.common.detail.viewmodels

import android.app.Application
import androidx.lifecycle.*
import com.idiot.data.api.OptionItem
import com.idiot.data.repository.HouseOptionRepository
import kotlinx.coroutines.launch

class HouseOptionViewModel(private val repository: HouseOptionRepository) : ViewModel() {
    private val _optionList = MutableLiveData<List<OptionItem>>()
    val optionList : LiveData<List<OptionItem>>
        get() = _optionList

    init {
        viewModelScope.launch {
            _optionList.value = repository.load()
        }
    }

    class Factory(private val application: Application): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return HouseOptionViewModel(HouseOptionRepository.getInstance(application)!!) as T
        }
    }
}