package com.omatt.fdlsandbox.components

import com.omatt.fdlsandbox.AppController
import com.omatt.fdlsandbox.modules.DeepLinkActivity
import com.omatt.fdlsandbox.modules.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by omarmatthew on 9/16/2017.
 * App Component
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, MainModule::class, DeepLinkModule::class))
interface AppComponent {
    fun inject(app: AppController)
    fun inject(mainActivity: MainActivity)
    fun inject(deepLinkActivity: DeepLinkActivity)
}