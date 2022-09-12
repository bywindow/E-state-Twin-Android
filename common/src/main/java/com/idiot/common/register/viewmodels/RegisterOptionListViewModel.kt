package com.idiot.common.register.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
        viewModelScope.launch {
            val currentStatus = _optionList.value
            val updatedStatus = currentStatus!!.toMutableMap()
            updatedStatus[item.id]?.hasOption = !item.hasOption
            _optionList.value = updatedStatus
        }
    }
}