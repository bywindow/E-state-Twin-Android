package com.idiot.feature.login.ui.sign

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.idiot.common.MainActivity
import com.idiot.feature.login.R
import com.idiot.feature.login.databinding.ActivitySignUpBinding
import com.idiot.feature.login.ui.main.LoginActivity
import com.idiot.feature.login.utils.UpdateViewOnEvent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SignUpActivity : AppCompatActivity() {

  private lateinit var binding: ActivitySignUpBinding
  private val viewModel: SignUpViewModel by viewModels()
  lateinit var accessToken: String

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
    binding.lifecycleOwner = this
    binding.vm = viewModel

    accessToken = intent.getStringExtra("accessToken").toString()

    binding.citiesRecyclerview.setHasFixedSize(true)
    binding.distinctRecyclerview.setHasFixedSize(true)

    binding.cityAdapter = CityAdapter(
      onClick = { pos -> viewModel.changePrefCity(pos) }).apply {
      stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT
    }
    binding.subCityAdapter = SubCityAdapter(
      onClick = { pos -> viewModel.changePrefSubCity(pos) }).apply {
      stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY
    }

    initCompleteButton()
    initCloseButton()
  }

  private fun initCompleteButton() {
    binding.completeButton.setOnClickListener {
      lifecycleScope.launch {
        viewModel.requestSingUp(accessToken).collect() {
          UpdateViewOnEvent.moveToMainActivity(it, this@SignUpActivity)
          finish()
        }
      }
    }
  }

  private fun initCloseButton() {
    binding.closeButton.setOnClickListener {
      startActivity(Intent(this, LoginActivity::class.java))
      finish()
    }
  }
}