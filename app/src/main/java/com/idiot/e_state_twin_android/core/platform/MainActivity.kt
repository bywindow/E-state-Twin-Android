package com.idiot.e_state_twin_android.core.platform

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.idiot.e_state_twin_android.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContentView(R.layout.activity_main)
    }

    fun setBottomNavigationBackground() {
        val radius = resources.getDimension(R.dimen.bottom_nav_corner)
        val bottomNavigation = findViewById<>(R.id.bottom_navigation)
        val bottomNavigationViewBackground = bottomNavigation.background
    }
}