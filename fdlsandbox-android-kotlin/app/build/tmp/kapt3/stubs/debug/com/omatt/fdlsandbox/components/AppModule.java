package com.omatt.fdlsandbox.components;

import java.lang.System;

/**
 * * Created by omarmatthew on 9/16/2017.
 * * App Module
 */
@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/omatt/fdlsandbox/components/AppModule;", "", "app", "Lcom/omatt/fdlsandbox/AppController;", "(Lcom/omatt/fdlsandbox/AppController;)V", "getApp", "()Lcom/omatt/fdlsandbox/AppController;", "provideApp", "app_debug"})
@dagger.Module()
public final class AppModule {
    @org.jetbrains.annotations.NotNull()
    private final com.omatt.fdlsandbox.AppController app = null;
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.omatt.fdlsandbox.AppController provideApp() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.omatt.fdlsandbox.AppController getApp() {
        return null;
    }
    
    public AppModule(@org.jetbrains.annotations.NotNull()
    com.omatt.fdlsandbox.AppController app) {
        super();
    }
}