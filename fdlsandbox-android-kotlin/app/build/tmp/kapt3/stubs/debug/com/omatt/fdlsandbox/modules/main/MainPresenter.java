package com.omatt.fdlsandbox.modules.main;

import java.lang.System;

/**
 * * Created by omarmatthew on 9/16/2017.
 * * MainActivity Presenter
 */
@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u001d"}, d2 = {"Lcom/omatt/fdlsandbox/modules/main/MainPresenter;", "Lcom/omatt/fdlsandbox/modules/main/MainContract$Presenter;", "()V", "TAG", "", "mainView", "Lcom/omatt/fdlsandbox/modules/main/MainContract$View;", "getMainView", "()Lcom/omatt/fdlsandbox/modules/main/MainContract$View;", "setMainView", "(Lcom/omatt/fdlsandbox/modules/main/MainContract$View;)V", "buildDynamicLink", "", "context", "Landroid/content/Context;", "dropView", "forceCrash", "catchCrash", "", "processDeepLink", "intent", "Landroid/content/Intent;", "sendAppInvite", "activity", "Landroid/app/Activity;", "resultCode", "", "takeView", "view", "app_debug"})
public final class MainPresenter implements com.omatt.fdlsandbox.modules.main.MainContract.Presenter {
    private final java.lang.String TAG = "MainPresenter";
    @org.jetbrains.annotations.NotNull()
    public com.omatt.fdlsandbox.modules.main.MainContract.View mainView;
    
    @org.jetbrains.annotations.NotNull()
    public final com.omatt.fdlsandbox.modules.main.MainContract.View getMainView() {
        return null;
    }
    
    public final void setMainView(@org.jetbrains.annotations.NotNull()
    com.omatt.fdlsandbox.modules.main.MainContract.View p0) {
    }
    
    /**
     * * Fetch view from MainActivity
     *     * @param view MainContract.View
     */
    @java.lang.Override()
    public void takeView(@org.jetbrains.annotations.NotNull()
    com.omatt.fdlsandbox.modules.main.MainContract.View view) {
    }
    
    /**
     * * Drop view
     *     * unsure if still necessary since there's JVM garbage collection
     */
    @java.lang.Override()
    public void dropView() {
    }
    
    @java.lang.Override()
    public void sendAppInvite(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, int resultCode) {
    }
    
    /**
     * * Process received Dynamic Link
     *     * @param intent Intent
     */
    @java.lang.Override()
    public void processDeepLink(@org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
    }
    
    /**
     * * Build long and short dynamic links
     *     * @param context Context
     */
    @java.lang.Override()
    public void buildDynamicLink(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @java.lang.Override()
    public void forceCrash(boolean catchCrash) {
    }
    
    public MainPresenter() {
        super();
    }
}