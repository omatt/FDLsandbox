package com.omatt.fdlsandbox.modules.inappbrowser;

import java.lang.System;

/**
 * * Created by User on 10/14/2017.
 */
@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/omatt/fdlsandbox/modules/inappbrowser/InAppBrowserContract;", "", "Presenter", "View", "app_debug"})
public abstract interface InAppBrowserContract {
    
    @kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J \u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H&J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rH&\u00a8\u0006\u000e"}, d2 = {"Lcom/omatt/fdlsandbox/modules/inappbrowser/InAppBrowserContract$View;", "Lcom/omatt/fdlsandbox/BaseView;", "Lcom/omatt/fdlsandbox/modules/inappbrowser/InAppBrowserContract$Presenter;", "loadUrl", "", "url", "", "loadWebViewData", "data", "mimeType", "encoding", "setWebViewClient", "webViewClient", "Landroid/webkit/WebViewClient;", "app_debug"})
    public static abstract interface View extends com.omatt.fdlsandbox.BaseView<com.omatt.fdlsandbox.modules.inappbrowser.InAppBrowserContract.Presenter> {
        
        public abstract void loadUrl(@org.jetbrains.annotations.NotNull()
        java.lang.String url);
        
        public abstract void setWebViewClient(@org.jetbrains.annotations.Nullable()
        android.webkit.WebViewClient webViewClient);
        
        public abstract void loadWebViewData(@org.jetbrains.annotations.NotNull()
        java.lang.String data, @org.jetbrains.annotations.NotNull()
        java.lang.String mimeType, @org.jetbrains.annotations.NotNull()
        java.lang.String encoding);
    }
    
    @kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/omatt/fdlsandbox/modules/inappbrowser/InAppBrowserContract$Presenter;", "Lcom/omatt/fdlsandbox/BasePresenter;", "Lcom/omatt/fdlsandbox/modules/inappbrowser/InAppBrowserContract$View;", "initWebView", "", "overrideWebView", "", "dynamicLink", "", "app_debug"})
    public static abstract interface Presenter extends com.omatt.fdlsandbox.BasePresenter<com.omatt.fdlsandbox.modules.inappbrowser.InAppBrowserContract.View> {
        
        public abstract void initWebView(boolean overrideWebView, @org.jetbrains.annotations.NotNull()
        java.lang.String dynamicLink);
    }
}