package com.omatt.fdlsandbox;

import java.lang.System;

/**
 * * Created by omarmatthew on 9/16/2017.
 * * App Controller
 */
@kotlin.Suppress(names = {"DEPRECATION"})
@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/omatt/fdlsandbox/AppController;", "Landroid/app/Application;", "()V", "onCreate", "", "Companion", "app_debug"})
public final class AppController extends android.app.Application {
    @org.jetbrains.annotations.NotNull()
    public static com.omatt.fdlsandbox.components.AppComponent component;
    @org.jetbrains.annotations.Nullable()
    private static com.omatt.fdlsandbox.AppController instance;
    public static final com.omatt.fdlsandbox.AppController.Companion Companion = null;
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    public AppController() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.omatt.fdlsandbox.components.AppComponent getComponent() {
        return null;
    }
    
    public static final void setComponent(@org.jetbrains.annotations.NotNull()
    com.omatt.fdlsandbox.components.AppComponent p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final com.omatt.fdlsandbox.AppController getInstance() {
        return null;
    }
    
    public static final void setInstance(@org.jetbrains.annotations.Nullable()
    com.omatt.fdlsandbox.AppController p0) {
    }
    
    @kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/omatt/fdlsandbox/AppController$Companion;", "", "()V", "component", "Lcom/omatt/fdlsandbox/components/AppComponent;", "component$annotations", "getComponent", "()Lcom/omatt/fdlsandbox/components/AppComponent;", "setComponent", "(Lcom/omatt/fdlsandbox/components/AppComponent;)V", "instance", "Lcom/omatt/fdlsandbox/AppController;", "instance$annotations", "getInstance", "()Lcom/omatt/fdlsandbox/AppController;", "setInstance", "(Lcom/omatt/fdlsandbox/AppController;)V", "app_debug"})
    public static final class Companion {
        
        public static void component$annotations() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.omatt.fdlsandbox.components.AppComponent getComponent() {
            return null;
        }
        
        public final void setComponent(@org.jetbrains.annotations.NotNull()
        com.omatt.fdlsandbox.components.AppComponent p0) {
        }
        
        public static void instance$annotations() {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.omatt.fdlsandbox.AppController getInstance() {
            return null;
        }
        
        public final void setInstance(@org.jetbrains.annotations.Nullable()
        com.omatt.fdlsandbox.AppController p0) {
        }
        
        private Companion() {
            super();
        }
    }
}