package com.idiot.common_ui.register

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.JavascriptInterface
import android.webkit.WebChromeClient
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.idiot.common_ui.R
import com.idiot.common_ui.databinding.FragmentAddressSearchDialogBinding

class AddressSearchDialogFragment : DialogFragment() {

    private lateinit var binding: FragmentAddressSearchDialogBinding

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.Theme_idiot_BottomSheet)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_address_search_dialog, container, false
        )
        navController = findNavController()
        initWebView()

        return binding.root
    }

    private fun initWebView(binding: FragmentAddressSearchDialogBinding) {
        val webView = binding.addressSearchWebView
        webView.settings.javaScriptEnabled = true
        webView.settings.javaScriptCanOpenWindowsAutomatically = true
        webView.webChromeClient = WebChromeClient()
        webView.addJavascriptInterface(AndroidBridge(), "Android")
        webView.loadUrl("https://idiot-model-bucket.s3.ap-northeast-2.amazonaws.com/static/daum_map.html")
    }

    inner class AndroidBridge {
        @JavascriptInterface
        fun processDATA(zoneCode: String, roadAddr: String, jibunAddr: String) {
            Thread(Runnable {
                val stateHandler = navController.previousBackStackEntry!!.savedStateHandle
                stateHandler["zoneCode"] = zoneCode
                stateHandler["roadAddr"] = roadAddr
                stateHandler["jibunAddr"] = jibunAddr
                dismiss()
            })
        }
    }
}
