package com.omatt.fdlsandbox.utils;

import android.app.Application;
import android.content.Context;

import com.omatt.fdlsandbox.components.AppComponent;
import com.omatt.fdlsandbox.components.DaggerAppComponent;
import com.omatt.fdlsandbox.components.FDLSandboxModule;

/**
 * Created by omarmatthew on 6/24/17.
 * Application Controller
 */

public class AppController extends Application{
    private static AppController sInstance;
    private AppComponent appComponent;

    /**
     * Get application instance
     *
     * @return AppController
     */
    public static AppController getsInstance() {
        return sInstance;
    }

    public static AppComponent getComponent(Context context) {
        return ((AppController) context.getApplicationContext()).appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

        // Initialize Dagger AppComponent
        appComponent = DaggerAppComponent.builder().fDLSandboxModule(new FDLSandboxModule(this)).build();
    }
}
