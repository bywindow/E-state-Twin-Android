package com.idiot.feature.login.ui.sign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.idiot.feature.login.R
import com.idiot.feature.login.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

  private val viewModel: SignUpViewModel by viewModels()
  private lateinit var binding: ActivitySignUpBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
    binding.lifecycleOwner = this
    binding.vm = viewModel
    binding.cityAdapter = CityAdapter(0)

//    initCityList()
  }

//  fun initCityList() {
//    val cityAdapter = CityAdapter(viewModel.preferenceCity)
//    binding.citiesRecyclerview.adapter = cityAdapter
//    lifecycleScope.launchWhenStarted {
//      cityAdapter.submitList(viewModel.cityList.toList())
//    }
//  }
}