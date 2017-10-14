package com.omatt.fdlsandbox.modules.webview

import android.webkit.WebView
import android.webkit.WebViewClient
import com.omatt.fdlsandbox.BasePresenter
import com.omatt.fdlsandbox.BaseView

/**
 * Created by User on 10/14/2017.
 */
interface InAppBrowserContract {
    interface View : BaseView<InAppBrowserContract.Presenter> {
        fun loadUrl(url: String)
        fun setWebViewClient(webViewClient: WebViewClient?)
        fun loadWebViewData(data : String, mimeType : String, encoding : String)
    }

    interface Presenter : BasePresenter<InAppBrowserContract.View> {
        fun initWebView(overrideWebView: Boolean, dynamicLink: String)
    }
}
