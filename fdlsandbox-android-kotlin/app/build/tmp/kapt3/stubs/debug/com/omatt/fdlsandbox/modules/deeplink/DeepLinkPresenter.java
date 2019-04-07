package com.omatt.fdlsandbox.modules.deeplink;

import java.lang.System;

/**
 * * Created by omarmatthew on 9/16/2017.
 * * DeepLinkActivity Presenter
 */
@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u0012"}, d2 = {"Lcom/omatt/fdlsandbox/modules/deeplink/DeepLinkPresenter;", "Lcom/omatt/fdlsandbox/modules/deeplink/DeepLinkContract$Presenter;", "()V", "TAG", "", "deepLinkView", "Lcom/omatt/fdlsandbox/modules/deeplink/DeepLinkContract$View;", "getDeepLinkView", "()Lcom/omatt/fdlsandbox/modules/deeplink/DeepLinkContract$View;", "setDeepLinkView", "(Lcom/omatt/fdlsandbox/modules/deeplink/DeepLinkContract$View;)V", "dropView", "", "processDeepLink", "intent", "Landroid/content/Intent;", "takeView", "view", "app_debug"})
public final class DeepLinkPresenter implements com.omatt.fdlsandbox.modules.deeplink.DeepLinkContract.Presenter {
    private final java.lang.String TAG = "DeepLinkPresenter";
    @org.jetbrains.annotations.NotNull()
    public com.omatt.fdlsandbox.modules.deeplink.DeepLinkContract.View deepLinkView;
    
    @org.jetbrains.annotations.NotNull()
    public final com.omatt.fdlsandbox.modules.deeplink.DeepLinkContract.View getDeepLinkView() {
        return null;
    }
    
    public final void setDeepLinkView(@org.jetbrains.annotations.NotNull()
    com.omatt.fdlsandbox.modules.deeplink.DeepLinkContract.View p0) {
    }
    
    @java.lang.Override()
    public void takeView(@org.jetbrains.annotations.NotNull()
    com.omatt.fdlsandbox.modules.deeplink.DeepLinkContract.View view) {
    }
    
    @java.lang.Override()
    public void dropView() {
    }
    
    @java.lang.Override()
    public void processDeepLink(@org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
    }
    
    public DeepLinkPresenter() {
        super();
    }
}