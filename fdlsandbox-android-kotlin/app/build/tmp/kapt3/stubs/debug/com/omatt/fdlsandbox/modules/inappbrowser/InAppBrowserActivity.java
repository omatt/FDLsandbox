package com.omatt.fdlsandbox.modules.inappbrowser;

import java.lang.System;

/**
 * * Created by omarmatthew on 10/14/2017.
 * * Simulates FDL behavior on an in-app browser
 */
@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005H\u0016J \u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005H\u0016J\u0012\u0010\u001e\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\b\u0010!\u001a\u00020\u0018H\u0014J\u0012\u0010\"\u001a\u00020\u00182\b\u0010#\u001a\u0004\u0018\u00010$H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006%"}, d2 = {"Lcom/omatt/fdlsandbox/modules/inappbrowser/InAppBrowserActivity;", "Landroid/support/v7/app/AppCompatActivity;", "Lcom/omatt/fdlsandbox/modules/inappbrowser/InAppBrowserContract$View;", "()V", "TAG", "", "checked", "", "getChecked", "()Z", "setChecked", "(Z)V", "dynamicLink", "getDynamicLink", "()Ljava/lang/String;", "setDynamicLink", "(Ljava/lang/String;)V", "inAppBrowserPresenter", "Lcom/omatt/fdlsandbox/modules/inappbrowser/InAppBrowserPresenter;", "getInAppBrowserPresenter", "()Lcom/omatt/fdlsandbox/modules/inappbrowser/InAppBrowserPresenter;", "setInAppBrowserPresenter", "(Lcom/omatt/fdlsandbox/modules/inappbrowser/InAppBrowserPresenter;)V", "loadUrl", "", "url", "loadWebViewData", "data", "mimeType", "encoding", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "setWebViewClient", "webViewClient", "Landroid/webkit/WebViewClient;", "app_debug"})
public final class InAppBrowserActivity extends android.support.v7.app.AppCompatActivity implements com.omatt.fdlsandbox.modules.inappbrowser.InAppBrowserContract.View {
    private final java.lang.String TAG = "InAppBrowserActivity";
    private boolean checked;
    @org.jetbrains.annotations.NotNull()
    public java.lang.String dynamicLink;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.omatt.fdlsandbox.modules.inappbrowser.InAppBrowserPresenter inAppBrowserPresenter;
    private java.util.HashMap _$_findViewCache;
    
    public final boolean getChecked() {
        return false;
    }
    
    public final void setChecked(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDynamicLink() {
        return null;
    }
    
    public final void setDynamicLink(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.omatt.fdlsandbox.modules.inappbrowser.InAppBrowserPresenter getInAppBrowserPresenter() {
        return null;
    }
    
    public final void setInAppBrowserPresenter(@org.jetbrains.annotations.NotNull()
    com.omatt.fdlsandbox.modules.inappbrowser.InAppBrowserPresenter p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    public void loadUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
    }
    
    @java.lang.Override()
    public void setWebViewClient(@org.jetbrains.annotations.Nullable()
    android.webkit.WebViewClient webViewClient) {
    }
    
    @java.lang.Override()
    public void loadWebViewData(@org.jetbrains.annotations.NotNull()
    java.lang.String data, @org.jetbrains.annotations.NotNull()
    java.lang.String mimeType, @org.jetbrains.annotations.NotNull()
    java.lang.String encoding) {
    }
    
    public InAppBrowserActivity() {
        super();
    }
}