package com.idiot.common.register.viewmodels

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.idiot.model.register.RegisterPicture
import kotlin.random.Random

class RegisterPictureListViewModel() : ViewModel() {
    private val _pictureList = MutableLiveData<List<RegisterPicture>>()
    val pictureList: LiveData<List<RegisterPicture>>
        get() = _pictureList

    fun insertPicture(fileName: String, filePath: Uri, size: Int) {
        val currentList = _pictureList.value
        val updatedList = currentList?.toMutableList()
        (0..size).forEach {
            val newItem = RegisterPicture(
                Random.nextLong(),
                fileName,
                filePath
            )
            updatedList?.add(newItem)
        }
        _pictureList.postValue(updatedList)
    }
}

class Factory() : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RegisterPictureListViewModel() as T
    }
}