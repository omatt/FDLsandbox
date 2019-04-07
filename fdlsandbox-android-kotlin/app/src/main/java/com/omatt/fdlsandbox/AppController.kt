package com.omatt.fdlsandbox

import android.app.Application
import android.util.Log
import com.crashlytics.android.core.CrashlyticsCore
import com.omatt.fdlsandbox.components.AppComponent
import com.omatt.fdlsandbox.components.AppModule
import com.omatt.fdlsandbox.components.DaggerAppComponent
import io.fabric.sdk.android.Fabric

// Suppress appModule deprecation warning
@Suppress("DEPRECATION")
/**
 * Created by omarmatthew on 9/16/2017.
 * App Controller
 */
class AppController : Application() {
    val build = false
    val TAG = "AppController"

    companion object {
        //platformStatic allow access it from java code
        @JvmStatic
        lateinit var component: AppComponent
        @JvmStatic
        var instance: AppController? = null
    }

    override fun onCreate() {
        instance = this
        component = DaggerAppComponent.builder().appModule(AppModule(this))
                .build()

        component.inject(this)

        val crashlyticsCore = CrashlyticsCore.Builder()
                .disabled(true)
                .build()
        Log.i(TAG, "Debug? ${BuildConfig.DEBUG}")
        Fabric.with(this, crashlyticsCore)

        super.onCreate()
    }
}