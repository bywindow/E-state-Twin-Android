package com.idiot.more.ui

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.idiot.more.R
import com.idiot.more.databinding.FragmentAddressSearchDialogBinding
import timber.log.Timber

class AddressSearchDialogFragment : DialogFragment() {

  private lateinit var binding: FragmentAddressSearchDialogBinding
  private lateinit var webView: WebView
  private lateinit var navController: NavController

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(
      inflater, R.layout.fragment_address_search_dialog, container, false
    )
    navController = findNavController()
    webView = binding.addressSearchWebView
    initWebView(binding)

    return binding.root
  }

  //TODO: FIX WEBVIEW ERROR
  private fun initWebView(binding: FragmentAddressSearchDialogBinding) {
    webView.settings.javaScriptEnabled = true
    webView.settings.javaScriptCanOpenWindowsAutomatically = true
    webView.addJavascriptInterface(AndroidBridge(), "Android")
    webView.settings.domStorageEnabled = true
    webView.webViewClient = WebViewClientClass()
    webView.webChromeClient = WebChromeClient()
    webView.loadUrl("http://www.estatetwin.net/m/daum.html")
  }

  inner class WebViewClientClass() : WebViewClient() {
    @SuppressLint("WebViewClientOnReceivedSslError")
    override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
      handler?.proceed()
    }
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
      view?.loadUrl(request?.url.toString())
      return true
    }
    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
      super.onPageStarted(view, url, favicon)
      Timber.d("페이지 시작")
    }
    override fun onPageFinished(view: WebView?, url: String?) {
      webView.loadUrl("javascript:sample2_execDaumPostcode();")
      Timber.d("페이지 로딩")
    }
  }

  inner class AndroidBridge {
    @JavascriptInterface
    fun processDATA(data: String) {
      Thread(Runnable {
        val stateHandler = navController.previousBackStackEntry!!.savedStateHandle
        stateHandler["data"] = data
        dismiss()
      })
    }
  }
}
