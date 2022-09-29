package com.idiot.feature.login.ui.sign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.idiot.common.MainActivity
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
    binding.cityAdapter =
      CityAdapter(selectedPosition = viewModel.preferenceCity.value, onClick = { pos ->
        viewModel.changePrefCity(pos)
      })
    binding.subCityAdapter = SubCityAdapter { pos -> viewModel.changePrefSubCity(pos) }

    initCompleteButton()
  }

  private fun initCompleteButton() {
    binding.completeButton.setOnClickListener {
      startActivity(Intent(this, com.idiot.common.MainActivity::class.java))
      finish()
    }
  }
}