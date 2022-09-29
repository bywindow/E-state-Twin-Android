package com.idiot.more.ui.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.idiot.data.repository.HouseOptionRepository
import com.idiot.model.HouseOption
import kotlinx.coroutines.launch

class RegisterOptionListViewModel(private val repository: HouseOptionRepository) : ViewModel() {
    private val _optionList = MutableLiveData<Map<Int, HouseOption>>()
    val optionList: LiveData<Map<Int, HouseOption>>
        get() = _optionList

    init {
        _optionList.value = repository.initForRegister().associateBy { it.id }
    }

    fun changeOptionStatus(item: HouseOption) {
        Log.d("register", item.toString())
        viewModelScope.launch {
            val currentStatus = _optionList.value
            val updatedStatus = currentStatus!!.toMutableMap()
            updatedStatus[item.id]?.hasOption = !item.hasOption
            _optionList.value = updatedStatus
        }
    }

    class OptionListFactory(private val application: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(RegisterOptionListViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return RegisterOptionListViewModel(HouseOptionRepository.getInstance(application)!!) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}