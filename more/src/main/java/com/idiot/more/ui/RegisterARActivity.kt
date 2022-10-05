package com.idiot.more.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import com.idiot.more.R
import com.idiot.more.databinding.ActivityRegisterAractivityBinding
import io.github.sceneview.utils.setFullScreen

class RegisterARActivity : AppCompatActivity() {

  lateinit var binding: ActivityRegisterAractivityBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = DataBindingUtil.setContentView(this, R.layout.activity_register_aractivity)

    setFullScreen(
      binding.arRootView,
      fullScreen = true,
      hideSystemBars = false,
      fitsSystemWindows = false
    )
    supportFragmentManager.commit {
      add(R.id.container_view, ArChecklistFragment::class.java, Bundle())
    }
  }
}