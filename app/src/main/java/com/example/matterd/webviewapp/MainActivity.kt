package com.example.matterd.webviewapp

import android.app.Activity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

class WebViewController: WebViewClient() {

    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        view!!.loadUrl(request!!.url.toString())
        return true
    }

}

class MainActivity : Activity() {
    private val webViewClient = WebViewController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView = findViewById<WebView>(R.id.webview)
        webView.settings.javaScriptEnabled = true
        webView?.webViewClient = webViewClient

        webView.loadUrl("file:///android_asset/index.html")
    }

    override fun onResume() {
        super.onResume()

        val webView = findViewById<WebView>(R.id.webview)
        webView.loadUrl("file:///android_asset/index.html")
    }
}
