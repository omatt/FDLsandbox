package com.omatt.fdlsandbox.components;

import java.lang.System;

/**
 * * Created by omarmatthew on 9/16/2017.
 * * MainActivity Module
 */
@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2 = {"Lcom/omatt/fdlsandbox/components/MainModule;", "", "()V", "provideMainPresenter", "Lcom/omatt/fdlsandbox/modules/main/MainPresenter;", "app_debug"})
@dagger.Module()
public final class MainModule {
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.omatt.fdlsandbox.modules.main.MainPresenter provideMainPresenter() {
        return null;
    }
    
    public MainModule() {
        super();
    }
}