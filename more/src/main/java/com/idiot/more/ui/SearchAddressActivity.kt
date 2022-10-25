package com.idiot.more.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.webkit.WebViewClient
import com.idiot.more.R
import timber.log.Timber

class SearchAddressActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_search_address)

    val webView: WebView = findViewById(R.id.web_view)
    webView.settings.javaScriptEnabled = true
    webView.addJavascriptInterface(BridgeInterface(), "Android")
    webView.webViewClient = object : WebViewClient() {
      override fun onPageFinished(view: WebView?, url: String?) {
        webView.loadUrl("javascript:sample2_execDaumPostcode();")
      }
    }
    webView.loadUrl("https://e-state-twin-a42a4.web.app")
  }

  inner class BridgeInterface {
    @JavascriptInterface
    fun processDATA(data: String) {
      Timber.d("ADDRESS : $data")
      val intent = Intent().apply { putExtra("data", data) }
      setResult(RESULT_OK, intent)
      finish()
    }
  }
}