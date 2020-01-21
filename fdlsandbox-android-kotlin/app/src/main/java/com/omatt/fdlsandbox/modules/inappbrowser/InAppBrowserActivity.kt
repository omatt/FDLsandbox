package com.omatt.fdlsandbox.modules.inappbrowser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.webkit.WebViewClient
import com.omatt.fdlsandbox.AppController
import com.omatt.fdlsandbox.R
import kotlinx.android.synthetic.main.layout_activity_in_app_browser.*
import javax.inject.Inject

/**
 * Created by omarmatthew on 10/14/2017.
 * Simulates FDL behavior on an in-app browser
 */
class InAppBrowserActivity : AppCompatActivity(), InAppBrowserContract.View {
    private val TAG = "InAppBrowserActivity"
    var checked = false
    lateinit var dynamicLink: String

    @Inject
    lateinit var inAppBrowserPresenter: InAppBrowserPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_activity_in_app_browser)
        AppController.component.inject(this)

        dynamicLink = intent.extras?.getString("KEY_FDL").toString()

        switch_override_webview.setOnCheckedChangeListener({ _, checked ->
            Log.i(TAG, "switch $checked")
            inAppBrowserPresenter.initWebView(checked, dynamicLink)
        })
    }

    override fun onResume() {
        super.onResume()
        inAppBrowserPresenter.takeView(this)
        inAppBrowserPresenter.initWebView(checked, dynamicLink)
    }

    // @OnCheckedChanged butterknife action doesn't seem to be triggered in Kotlin
    // If true, the dynamic link will be forced to be load in the WebView
//    @OnCheckedChanged(R.id.switch_override_webview)
//    internal fun onSwitchChanged(checked: Boolean) {
//        Log.i(TAG, "switch $checked")
//        inAppBrowserPresenter.initWebView(checked, dynamicLink)
//    }

    override fun loadUrl(url: String) {
        webview.loadUrl(url)
    }

    override fun setWebViewClient(webViewClient: WebViewClient?) {
        webview.webViewClient = webViewClient
    }

    override fun loadWebViewData(data: String, mimeType: String, encoding: String) {
        webview.loadData(data, mimeType, encoding)
    }
}