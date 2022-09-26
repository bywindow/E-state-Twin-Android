package com.idiot.feature.login.ui.sign

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.idiot.feature.login.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(application: Application) :
  AndroidViewModel(application) {

  private val _preferenceCity = MutableStateFlow(0)
  val preferenceCity: StateFlow<Int> = _preferenceCity

  val cityList: Array<String> = getApplication<Application>().resources.getStringArray(R.array.cities)

}

//data class CityList(var city: List<City>)
//
//data class City(
//  val name: String,
//  var isChecked: Boolean
//)