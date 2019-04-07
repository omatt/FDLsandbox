package com.omatt.fdlsandbox.modules.main;

import java.lang.System;

/**
 * * Class : ParentClass(), Interface
 * * Overriding rules, inheritance
 * * https://kotlinlang.org/docs/reference/classes.html#overriding-rules
 */
@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010#\u001a\u00020$H\u0007J\"\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010\'\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\b\u0010*\u001a\u00020$H\u0007J\u0012\u0010+\u001a\u00020$2\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\b\u0010.\u001a\u00020$H\u0014J\b\u0010/\u001a\u00020$H\u0014J\u0010\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020\tH\u0007J\b\u00102\u001a\u00020$H\u0007J\b\u00103\u001a\u00020$H\u0007J\u0010\u00104\u001a\u00020$2\u0006\u00105\u001a\u00020\u0007H\u0016J\u0010\u00106\u001a\u00020$2\u0006\u00105\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u00020\u001b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001f\u00a8\u00067"}, d2 = {"Lcom/omatt/fdlsandbox/modules/main/MainActivity;", "Landroid/support/v7/app/AppCompatActivity;", "Lcom/omatt/fdlsandbox/modules/main/MainContract$View;", "()V", "REQUEST_INVITE", "", "TAG", "", "catchCrash", "", "getCatchCrash", "()Z", "setCatchCrash", "(Z)V", "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "getFirebaseAnalytics", "()Lcom/google/firebase/analytics/FirebaseAnalytics;", "setFirebaseAnalytics", "(Lcom/google/firebase/analytics/FirebaseAnalytics;)V", "mainPresenter", "Lcom/omatt/fdlsandbox/modules/main/MainPresenter;", "getMainPresenter", "()Lcom/omatt/fdlsandbox/modules/main/MainPresenter;", "setMainPresenter", "(Lcom/omatt/fdlsandbox/modules/main/MainPresenter;)V", "textViewFDLLong", "Landroid/widget/TextView;", "getTextViewFDLLong", "()Landroid/widget/TextView;", "setTextViewFDLLong", "(Landroid/widget/TextView;)V", "textViewFDLShort", "getTextViewFDLShort", "setTextViewFDLShort", "generateFDL", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClickCrash", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onSwitchChanged", "checked", "openInAppBrowser", "sendAppInvite", "updateDynamicLinkLong", "link", "updateDynamicLinkShort", "app_debug"})
public final class MainActivity extends android.support.v7.app.AppCompatActivity implements com.omatt.fdlsandbox.modules.main.MainContract.View {
    private final java.lang.String TAG = "MainActivity";
    private final int REQUEST_INVITE = 0;
    private boolean catchCrash;
    
    /**
     * * lateinit - Late-initialized Properties
     *     * https://kotlinlang.org/docs/reference/properties.html#late-initialized-properties
     */
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public com.omatt.fdlsandbox.modules.main.MainPresenter mainPresenter;
    @org.jetbrains.annotations.NotNull()
    public com.google.firebase.analytics.FirebaseAnalytics firebaseAnalytics;
    @org.jetbrains.annotations.NotNull()
    @butterknife.BindView(value = com.omatt.fdlsandbox.R.id.textView_fdl_long)
    public android.widget.TextView textViewFDLLong;
    @org.jetbrains.annotations.NotNull()
    @butterknife.BindView(value = com.omatt.fdlsandbox.R.id.textView_fdl_short)
    public android.widget.TextView textViewFDLShort;
    private java.util.HashMap _$_findViewCache;
    
    public final boolean getCatchCrash() {
        return false;
    }
    
    public final void setCatchCrash(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.omatt.fdlsandbox.modules.main.MainPresenter getMainPresenter() {
        return null;
    }
    
    public final void setMainPresenter(@org.jetbrains.annotations.NotNull()
    com.omatt.fdlsandbox.modules.main.MainPresenter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.analytics.FirebaseAnalytics getFirebaseAnalytics() {
        return null;
    }
    
    public final void setFirebaseAnalytics(@org.jetbrains.annotations.NotNull()
    com.google.firebase.analytics.FirebaseAnalytics p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getTextViewFDLLong() {
        return null;
    }
    
    public final void setTextViewFDLLong(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getTextViewFDLShort() {
        return null;
    }
    
    public final void setTextViewFDLShort(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    /**
     * * Take MainActivity view onResume
     */
    @java.lang.Override()
    protected void onResume() {
    }
    
    /**
     * * Drop MainActivity view onDestroy
     */
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @butterknife.OnClick(value = {2131165222})
    public final void sendAppInvite() {
    }
    
    @butterknife.OnClick(value = {2131165224})
    public final void generateFDL() {
    }
    
    @butterknife.OnClick(value = {2131165225})
    public final void openInAppBrowser() {
    }
    
    @butterknife.OnClick(value = {2131165223})
    public final void onClickCrash() {
    }
    
    @butterknife.OnCheckedChanged(value = {2131165317})
    public final void onSwitchChanged(boolean checked) {
    }
    
    /**
     * * Update long dynamic link
     */
    @java.lang.Override()
    public void updateDynamicLinkLong(@org.jetbrains.annotations.NotNull()
    java.lang.String link) {
    }
    
    /**
     * * Update short dynamic link
     */
    @java.lang.Override()
    public void updateDynamicLinkShort(@org.jetbrains.annotations.NotNull()
    java.lang.String link) {
    }
    
    public MainActivity() {
        super();
    }
}