package com.idiot.common_ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.idiot.common.MainActivityViewModel
import com.idiot.common_ui.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val viewModel by viewModels<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        initBinding()
        initNavigation()
//        Log.d("keyHash", ""+getKeyHash(this));
    }

//    private fun setUpSplashScreen() {
//        val content: View = findViewById(android.R.id.content)
//        // TODO : viewModel 추가하고 초기 데이터 세팅 작업
//        content.viewTreeObserver.addOnPreDrawListener(
//            object : ViewTreeObserver.OnPreDrawListener {
//                override fun onPreDraw(): Boolean {
//                    // Check if the initial data is ready.
//                    return if (viewModel.complete.value == true) {
//                        // The content is ready; start drawing.
//                        content.viewTreeObserver.removeOnPreDrawListener(this)
//                        true
//                    } else {
//                        // The content is not ready; suspend.
//                        false
//                    }
//                    return false
//                }
//            }
//        )
//
//        Handler(mainLooper).postDelayed({
//            viewModel.updateComplete()
//        },500)
//    }

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

//    fun getKeyHash(context: Context): String? {
//        val pm: PackageManager = context.getPackageManager()
//        try {
//            val packageInfo: PackageInfo =
//                pm.getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES)
//                    ?: return null
//            for (signature in packageInfo.signatures) {
//                try {
//                    val md: MessageDigest = MessageDigest.getInstance("SHA")
//                    md.update(signature.toByteArray())
//                    return Base64.encodeToString(md.digest(), Base64.NO_WRAP)
//                } catch (e: NoSuchAlgorithmException) {
//                    e.printStackTrace()
//                }
//            }
//        } catch (e: PackageManager.NameNotFoundException) {
//            e.printStackTrace()
//        }
//        return null
//    }
}