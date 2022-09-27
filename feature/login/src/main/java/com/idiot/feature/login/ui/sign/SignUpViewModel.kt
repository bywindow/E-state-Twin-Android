package com.idiot.feature.login.ui.sign

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.idiot.feature.login.R
import com.idiot.model.users.UserPreference
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(application: Application) :
  AndroidViewModel(application) {

  private val _preferenceTrans = MutableStateFlow(0)
  val preferenceTrans: StateFlow<Int> = _preferenceTrans

  private val _preferenceEstate = MutableStateFlow(0)
  val preferenceEstate: StateFlow<Int> = _preferenceEstate

  private val _preferenceCity = MutableStateFlow(0)
  val preferenceCity: StateFlow<Int> = _preferenceCity

  private val _cityList = MutableStateFlow<List<UserPreference>>(emptyList())
  val cityList: StateFlow<List<UserPreference>> = _cityList

  init {
    val cities = getApplication<Application>().resources.getStringArray(R.array.cities)
    val temp: MutableList<UserPreference> = mutableListOf()
    cities.forEachIndexed { index, item ->
      temp.add(index, UserPreference(id = index, name = item, isChecked = false))
    }
    _cityList.value = temp
  }


  fun changePrefCity(position: Int) {
    _preferenceCity.value = position
    _cityList.value = _cityList.value.map {
      if (it.id == position) {
        it.copy(isChecked = !it.isChecked)
      } else it
    }
    Log.d("TAG", "${cityList.value}")
  }

  fun changePrefTrans(type: Int) {
    _preferenceTrans.value = type
  }

  fun changePrefEstate(type: Int) {
    _preferenceEstate.value = type
  }
}