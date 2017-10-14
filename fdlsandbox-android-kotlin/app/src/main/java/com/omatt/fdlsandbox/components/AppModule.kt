package com.omatt.fdlsandbox.components

import com.omatt.fdlsandbox.AppController
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by omarmatthew on 9/16/2017.
 * App Module
 */
@Module
class AppModule(val app : AppController) {
    @Provides
    @Singleton
    fun provideApp() = app
}