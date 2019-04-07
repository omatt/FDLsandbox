package com.omatt.fdlsandbox.components;

import java.lang.System;

/**
 * * Created by omarmatthew on 9/16/2017.
 * * App Component
 */
@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/omatt/fdlsandbox/components/AppComponent;", "", "inject", "", "app", "Lcom/omatt/fdlsandbox/AppController;", "deepLinkActivity", "Lcom/omatt/fdlsandbox/modules/deeplink/DeepLinkActivity;", "inAppBrowserActivity", "Lcom/omatt/fdlsandbox/modules/inappbrowser/InAppBrowserActivity;", "mainActivity", "Lcom/omatt/fdlsandbox/modules/main/MainActivity;", "app_debug"})
@dagger.Component(modules = {com.omatt.fdlsandbox.components.AppModule.class, com.omatt.fdlsandbox.components.MainModule.class, com.omatt.fdlsandbox.components.DeepLinkModule.class, com.omatt.fdlsandbox.components.InAppBrowserModule.class})
@javax.inject.Singleton()
public abstract interface AppComponent {
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.omatt.fdlsandbox.AppController app);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.omatt.fdlsandbox.modules.main.MainActivity mainActivity);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.omatt.fdlsandbox.modules.deeplink.DeepLinkActivity deepLinkActivity);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.omatt.fdlsandbox.modules.inappbrowser.InAppBrowserActivity inAppBrowserActivity);
}