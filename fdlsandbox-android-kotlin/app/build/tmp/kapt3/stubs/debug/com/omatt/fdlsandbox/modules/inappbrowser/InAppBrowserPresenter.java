package com.omatt.fdlsandbox.modules.inappbrowser;

import java.lang.System;

/**
 * * Created by omarmatthew on 10/14/2017.
 * * InAppBrowserActivity Presenter
 */
@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u0012"}, d2 = {"Lcom/omatt/fdlsandbox/modules/inappbrowser/InAppBrowserPresenter;", "Lcom/omatt/fdlsandbox/modules/inappbrowser/InAppBrowserContract$Presenter;", "()V", "inAppBrowserView", "Lcom/omatt/fdlsandbox/modules/inappbrowser/InAppBrowserContract$View;", "getInAppBrowserView", "()Lcom/omatt/fdlsandbox/modules/inappbrowser/InAppBrowserContract$View;", "setInAppBrowserView", "(Lcom/omatt/fdlsandbox/modules/inappbrowser/InAppBrowserContract$View;)V", "dropView", "", "initWebView", "overrideWebView", "", "dynamicLink", "", "takeView", "view", "app_debug"})
public final class InAppBrowserPresenter implements com.omatt.fdlsandbox.modules.inappbrowser.InAppBrowserContract.Presenter {
    @org.jetbrains.annotations.NotNull()
    public com.omatt.fdlsandbox.modules.inappbrowser.InAppBrowserContract.View inAppBrowserView;
    
    @org.jetbrains.annotations.NotNull()
    public final com.omatt.fdlsandbox.modules.inappbrowser.InAppBrowserContract.View getInAppBrowserView() {
        return null;
    }
    
    public final void setInAppBrowserView(@org.jetbrains.annotations.NotNull()
    com.omatt.fdlsandbox.modules.inappbrowser.InAppBrowserContract.View p0) {
    }
    
    @java.lang.Override()
    public void takeView(@org.jetbrains.annotations.NotNull()
    com.omatt.fdlsandbox.modules.inappbrowser.InAppBrowserContract.View view) {
    }
    
    @java.lang.Override()
    public void dropView() {
    }
    
    @java.lang.Override()
    public void initWebView(boolean overrideWebView, @org.jetbrains.annotations.NotNull()
    java.lang.String dynamicLink) {
    }
    
    public InAppBrowserPresenter() {
        super();
    }
}