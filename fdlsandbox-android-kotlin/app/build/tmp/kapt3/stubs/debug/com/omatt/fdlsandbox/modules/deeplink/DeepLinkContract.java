package com.omatt.fdlsandbox.modules.deeplink;

import java.lang.System;

/**
 * * Created by omarmatthew on 9/16/2017.
 */
@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/omatt/fdlsandbox/modules/deeplink/DeepLinkContract;", "", "Presenter", "View", "app_debug"})
public abstract interface DeepLinkContract {
    
    @kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H&\u00a8\u0006\u000b"}, d2 = {"Lcom/omatt/fdlsandbox/modules/deeplink/DeepLinkContract$View;", "Lcom/omatt/fdlsandbox/BaseView;", "Lcom/omatt/fdlsandbox/modules/deeplink/DeepLinkContract$Presenter;", "updateDeepLink", "", "deepLink", "", "updateInviteId", "inviteId", "updateReferrerId", "referrerId", "app_debug"})
    public static abstract interface View extends com.omatt.fdlsandbox.BaseView<com.omatt.fdlsandbox.modules.deeplink.DeepLinkContract.Presenter> {
        
        public abstract void updateDeepLink(@org.jetbrains.annotations.NotNull()
        java.lang.String deepLink);
        
        public abstract void updateInviteId(@org.jetbrains.annotations.NotNull()
        java.lang.String inviteId);
        
        public abstract void updateReferrerId(@org.jetbrains.annotations.NotNull()
        java.lang.String referrerId);
    }
    
    @kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/omatt/fdlsandbox/modules/deeplink/DeepLinkContract$Presenter;", "Lcom/omatt/fdlsandbox/BasePresenter;", "Lcom/omatt/fdlsandbox/modules/deeplink/DeepLinkContract$View;", "processDeepLink", "", "intent", "Landroid/content/Intent;", "app_debug"})
    public static abstract interface Presenter extends com.omatt.fdlsandbox.BasePresenter<com.omatt.fdlsandbox.modules.deeplink.DeepLinkContract.View> {
        
        public abstract void processDeepLink(@org.jetbrains.annotations.NotNull()
        android.content.Intent intent);
    }
}