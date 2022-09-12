package com.idiot.common_ui

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.idiot.common_ui.databinding.ActivityMainBinding
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        initBinding()
        initNavigation()
        Log.d("keyHash", ""+getKeyHash(this));
    }

    private fun initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
    }

    private fun initNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigation.setupWithNavController(navController)

        navController.addOnDestinationChangedListener {_, destination, _ ->
            when (destination.id) {
                R.id.homeFragment -> showBottomNav()
                R.id.interestFragment -> showBottomNav()
                R.id.searchFragment -> showBottomNav()
                R.id.myHouseFragment -> showBottomNav()
                R.id.moreFragment -> showBottomNav()
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

    fun getKeyHash(context: Context): String? {
        val pm: PackageManager = context.getPackageManager()
        try {
            val packageInfo: PackageInfo =
                pm.getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES)
                    ?: return null
            for (signature in packageInfo.signatures) {
                try {
                    val md: MessageDigest = MessageDigest.getInstance("SHA")
                    md.update(signature.toByteArray())
                    return Base64.encodeToString(md.digest(), Base64.NO_WRAP)
                } catch (e: NoSuchAlgorithmException) {
                    e.printStackTrace()
                }
            }
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return null
    }
}