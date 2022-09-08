package com.idiot.common.register.viewmodels

import android.content.ClipData
import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.idiot.model.register.RegisterPicture
import java.util.*
import kotlin.random.Random

class RegisterPictureListViewModel() : ViewModel() {
    private val _pictureList = MutableLiveData<List<RegisterPicture>>()
    val pictureList: LiveData<List<RegisterPicture>>
        get() = _pictureList

    fun insertPicture(clipData: ClipData, size: Int) {
//        Log.d("register", "$clipData , $size")
        val currentList = _pictureList.value
        val updatedList = if (currentList == null) mutableListOf<RegisterPicture>() else currentList?.toMutableList()
        (0 until size).forEach {
            val newItem = RegisterPicture(
                Random.nextLong(),
                UUID.randomUUID().toString(),
                clipData.getItemAt(it).uri
            )
            updatedList?.add(newItem)
            Log.d("register", "$newItem")
        }
        _pictureList.postValue(updatedList)
        Log.d("register", _pictureList.value.toString())
    }
}

class PictureListFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegisterPictureListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RegisterPictureListViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}