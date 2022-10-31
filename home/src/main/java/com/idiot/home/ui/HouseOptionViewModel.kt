package com.idiot.home.ui

import android.app.Application
import androidx.lifecycle.*
import com.idiot.data.repository.samples.optionSample
import com.idiot.model.HouseOption
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HouseOptionViewModel @Inject constructor(

) : ViewModel() {
    private val _optionList = MutableLiveData<List<HouseOption>>()
    val optionList : LiveData<List<HouseOption>>
        get() = _optionList

    init {
        viewModelScope.launch {
            _optionList.value = optionSample()
        }
    }

    class Factory(private val application: Application): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return HouseOptionViewModel() as T
        }
    }
}