package com.idiot.home.ui

import android.app.Application
import androidx.lifecycle.*
import com.idiot.data.repository.HouseOptionRepository
import com.idiot.model.HouseOption
import kotlinx.coroutines.launch

class HouseOptionViewModel(private val repository: HouseOptionRepository) : ViewModel() {
    private val _optionList = MutableLiveData<List<HouseOption>>()
    val optionList : LiveData<List<HouseOption>>
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