package com.omatt.fdlsandbox.modules.main;

import java.lang.System;

/**
 * * Created by omarmatthew on 9/16/2017.
 * * Main Contract
 */
@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/omatt/fdlsandbox/modules/main/MainContract;", "", "Presenter", "View", "app_debug"})
public abstract interface MainContract {
    
    @kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\b"}, d2 = {"Lcom/omatt/fdlsandbox/modules/main/MainContract$View;", "Lcom/omatt/fdlsandbox/BaseView;", "Lcom/omatt/fdlsandbox/modules/main/MainContract$Presenter;", "updateDynamicLinkLong", "", "link", "", "updateDynamicLinkShort", "app_debug"})
    public static abstract interface View extends com.omatt.fdlsandbox.BaseView<com.omatt.fdlsandbox.modules.main.MainContract.Presenter> {
        
        public abstract void updateDynamicLinkLong(@org.jetbrains.annotations.NotNull()
        java.lang.String link);
        
        public abstract void updateDynamicLinkShort(@org.jetbrains.annotations.NotNull()
        java.lang.String link);
    }
    
    @kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH&J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&\u00a8\u0006\u0012"}, d2 = {"Lcom/omatt/fdlsandbox/modules/main/MainContract$Presenter;", "Lcom/omatt/fdlsandbox/BasePresenter;", "Lcom/omatt/fdlsandbox/modules/main/MainContract$View;", "buildDynamicLink", "", "context", "Landroid/content/Context;", "forceCrash", "catchCrash", "", "processDeepLink", "intent", "Landroid/content/Intent;", "sendAppInvite", "activity", "Landroid/app/Activity;", "resultCode", "", "app_debug"})
    public static abstract interface Presenter extends com.omatt.fdlsandbox.BasePresenter<com.omatt.fdlsandbox.modules.main.MainContract.View> {
        
        public abstract void sendAppInvite(@org.jetbrains.annotations.NotNull()
        android.app.Activity activity, int resultCode);
        
        public abstract void processDeepLink(@org.jetbrains.annotations.NotNull()
        android.content.Intent intent);
        
        public abstract void buildDynamicLink(@org.jetbrains.annotations.NotNull()
        android.content.Context context);
        
        public abstract void forceCrash(boolean catchCrash);
    }
}