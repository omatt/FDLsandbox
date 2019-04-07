package com.omatt.fdlsandbox.modules.deeplink;

import java.lang.System;

/**
 * * Created by omarmatthew on 9/16/2017.
 * * Handles incoming dynamic links from app invites {host}/invites
 */
@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0007J\u0012\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0019H\u0014J\b\u0010\u001e\u001a\u00020\u0019H\u0014J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0005H\u0016J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u0005H\u0016J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001e\u0010\u0015\u001a\u00020\r8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011\u00a8\u0006%"}, d2 = {"Lcom/omatt/fdlsandbox/modules/deeplink/DeepLinkActivity;", "Landroid/support/v7/app/AppCompatActivity;", "Lcom/omatt/fdlsandbox/modules/deeplink/DeepLinkContract$View;", "()V", "TAG", "", "deepLinkPresenter", "Lcom/omatt/fdlsandbox/modules/deeplink/DeepLinkPresenter;", "getDeepLinkPresenter", "()Lcom/omatt/fdlsandbox/modules/deeplink/DeepLinkPresenter;", "setDeepLinkPresenter", "(Lcom/omatt/fdlsandbox/modules/deeplink/DeepLinkPresenter;)V", "textViewDeepLink", "Landroid/widget/TextView;", "getTextViewDeepLink", "()Landroid/widget/TextView;", "setTextViewDeepLink", "(Landroid/widget/TextView;)V", "textViewInviteId", "getTextViewInviteId", "setTextViewInviteId", "textViewReferrerId", "getTextViewReferrerId", "setTextViewReferrerId", "onClickOK", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "updateDeepLink", "deepLink", "updateInviteId", "inviteId", "updateReferrerId", "referrerId", "app_debug"})
public final class DeepLinkActivity extends android.support.v7.app.AppCompatActivity implements com.omatt.fdlsandbox.modules.deeplink.DeepLinkContract.View {
    private final java.lang.String TAG = "DeepLinkActivity";
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.omatt.fdlsandbox.modules.deeplink.DeepLinkPresenter deepLinkPresenter;
    @org.jetbrains.annotations.NotNull()
    @butterknife.BindView(value = com.omatt.fdlsandbox.R.id.textView_deep_link)
    public android.widget.TextView textViewDeepLink;
    @org.jetbrains.annotations.NotNull()
    @butterknife.BindView(value = com.omatt.fdlsandbox.R.id.textView_invite_id)
    public android.widget.TextView textViewInviteId;
    @org.jetbrains.annotations.NotNull()
    @butterknife.BindView(value = com.omatt.fdlsandbox.R.id.textView_referrer_id)
    public android.widget.TextView textViewReferrerId;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.omatt.fdlsandbox.modules.deeplink.DeepLinkPresenter getDeepLinkPresenter() {
        return null;
    }
    
    public final void setDeepLinkPresenter(@org.jetbrains.annotations.NotNull()
    com.omatt.fdlsandbox.modules.deeplink.DeepLinkPresenter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getTextViewDeepLink() {
        return null;
    }
    
    public final void setTextViewDeepLink(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getTextViewInviteId() {
        return null;
    }
    
    public final void setTextViewInviteId(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getTextViewReferrerId() {
        return null;
    }
    
    public final void setTextViewReferrerId(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @butterknife.OnClick(value = {2131165221})
    public final void onClickOK() {
    }
    
    @java.lang.Override()
    public void updateDeepLink(@org.jetbrains.annotations.NotNull()
    java.lang.String deepLink) {
    }
    
    @java.lang.Override()
    public void updateInviteId(@org.jetbrains.annotations.NotNull()
    java.lang.String inviteId) {
    }
    
    @java.lang.Override()
    public void updateReferrerId(@org.jetbrains.annotations.NotNull()
    java.lang.String referrerId) {
    }
    
    public DeepLinkActivity() {
        super();
    }
}