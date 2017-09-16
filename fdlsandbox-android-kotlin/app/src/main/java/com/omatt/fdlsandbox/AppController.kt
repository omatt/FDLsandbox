package com.omatt.fdlsandbox

import android.app.Application
import com.omatt.fdlsandbox.components.AppComponent
import com.omatt.fdlsandbox.components.AppModule
import com.omatt.fdlsandbox.components.DaggerAppComponent

// Suppress appModule deprecation warning
@Suppress("DEPRECATION")
/**
 * Created by omarmatthew on 9/16/2017.
 * App Controller
 */
class AppController : Application() {

    companion object {
        //platformStatic allow access it from java code
        @JvmStatic lateinit var component: AppComponent
        @JvmStatic
        var instance: AppController? = null
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        component = DaggerAppComponent.builder().appModule(AppModule(this))
                .build()

        component.inject(this)
    }
}