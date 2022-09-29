package com.idiot.common

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.idiot.common.R
import com.idiot.common.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    WindowCompat.setDecorFitsSystemWindows(window, false)
    initBinding()
    initNavigation()
  }

  private fun initBinding() {
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    binding.lifecycleOwner = this
  }

  private fun initNavigation() {
    val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
    val navController = navHostFragment.navController
    binding.bottomNavigation.setupWithNavController(navController)

    navController.addOnDestinationChangedListener { _, destination, _ ->
      when (destination.id) {
        com.idiot.home.R.id.homeFragment -> showBottomNav()
        com.idiot.dip.R.id.interestFragment -> showBottomNav()
        com.idiot.search.R.id.searchFragment -> showBottomNav()
        com.idiot.userhouse.R.id.myHouseFragment -> showBottomNav()
        com.idiot.more.R.id.moreFragment -> showBottomNav()
        else -> hideBottomNav()
      }
    }
  }

  private fun showBottomNav() {
    binding.bottomNavigation.visibility = View.VISIBLE
  }

  private fun hideBottomNav() {
    binding.bottomNavigation.visibility = View.GONE
  }
}