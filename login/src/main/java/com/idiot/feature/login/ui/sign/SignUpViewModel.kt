package com.idiot.feature.login.ui.sign

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.idiot.feature.login.R
import com.idiot.feature.login.utils.TransactionTypeUtils
import com.idiot.model.users.UserPreference
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import timber.log.Timber
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

  private val _preferenceSubCity = MutableStateFlow(0)
  val preferenceSubCity: StateFlow<Int> = _preferenceSubCity

  private val _subList = MutableStateFlow<List<UserPreference>>(emptyList())
  val subList: StateFlow<List<UserPreference>> = _subList

  init {
    val cities = getApplication<Application>().resources.getStringArray(R.array.cities)
    val temp: MutableList<UserPreference> = mutableListOf()
    cities.forEachIndexed { index, item ->
      if (index == 0) temp.add(index, UserPreference(id = index, name = item, isChecked = true))
      else temp.add(index, UserPreference(id = index, name = item, isChecked = false))
    }
    _cityList.value = temp
    val subTemp: MutableList<UserPreference> = mutableListOf()
    TransactionTypeUtils.getSubCityList(0, application).forEachIndexed { index, item ->
      if (index == 0) subTemp.add(index, UserPreference(id = index, name = item, isChecked = true))
      else subTemp.add(index, UserPreference(id = index, name = item, isChecked = false))
    }
    _subList.value = subTemp
  }

  fun changePrefTrans(type: Int) {
    _preferenceTrans.value = type
    Timber.d("선호거래유형 : ${preferenceTrans.value}, ${preferenceEstate.value}\t 선호지역 : ${preferenceCity.value}, ${preferenceSubCity.value}")
  }

  fun changePrefEstate(type: Int) {
    _preferenceEstate.value = type
  }

  fun changePrefCity(position: Int) {
    if (position == preferenceCity.value) return
    _preferenceCity.value = position
    val subTemp: MutableList<UserPreference> = mutableListOf()
    TransactionTypeUtils.getSubCityList(position, getApplication()).forEachIndexed { index, item ->
      if (index == 0) subTemp.add(index, UserPreference(id = index, name = item, isChecked = true))
      else subTemp.add(index, UserPreference(id = index, name = item, isChecked = false))
    }
    _subList.value = subTemp
    _preferenceSubCity.value = 0
  }

  fun changePrefSubCity(position: Int) {
    if (position == preferenceSubCity.value) return
    _preferenceSubCity.value = position
  }
}