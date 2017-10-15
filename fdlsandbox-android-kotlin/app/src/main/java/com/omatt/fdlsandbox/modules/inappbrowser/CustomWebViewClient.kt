package com.omatt.fdlsandbox.modules.inappbrowser

import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

/**
 * Created by omarmatthew on 10/14/2017.
 * Custom WebViewClient to override URL loading
 */
class CustomWebViewClient : WebViewClient() {
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        Log.i("CustomWebViewClient", "request url ${request?.url}")
        view?.loadUrl(request?.url.toString())
        return true
    }
}