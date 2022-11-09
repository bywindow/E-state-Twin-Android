package com.idiot.home.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.idiot.home.R
import com.idiot.home.databinding.ActivityResolveAnchorBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResolveAnchorActivity : AppCompatActivity() {

  private lateinit var binding: ActivityResolveAnchorBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_resolve_anchor)
  }
}