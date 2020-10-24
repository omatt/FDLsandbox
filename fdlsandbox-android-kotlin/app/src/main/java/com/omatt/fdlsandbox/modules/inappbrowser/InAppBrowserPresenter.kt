package com.omatt.fdlsandbox.modules.inappbrowser

/**
 * Created by omarmatthew on 10/14/2017.
 * InAppBrowserActivity Presenter
 */
class InAppBrowserPresenter : InAppBrowserContract.Presenter {
    lateinit var inAppBrowserView: InAppBrowserContract.View

    override fun takeView(view: InAppBrowserContract.View) {
        inAppBrowserView = view
    }

    override fun dropView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    // overrideWebView - if TRUE, force FDL to load in WebView
    override fun initWebView(overrideWebView: Boolean, dynamicLink: String) {
        if (overrideWebView) inAppBrowserView.setWebViewClient(CustomWebViewClient())
        else inAppBrowserView.setWebViewClient(null)
        inAppBrowserView.loadWebViewData(
                "<html>\n" +
                        "<body>\n" +
                        "Click <a href=\"" + dynamicLink + "\">here</a> to go to your FDL.\n" +
                        "</body>\n" +
                        "</html>",
                "text/html; charset=utf-8", "UTF-8")
    }

}