package com.omatt.fdlsandbox.components

import com.omatt.fdlsandbox.modules.main.MainPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by omarmatthew on 9/16/2017.
 * MainActivity Module
 */
@Module
class MainModule {

    @Provides
    @Singleton
    fun provideMainPresenter() = MainPresenter()

    // Moved initialization to MainActivity as AppController.instance gets errors
//    @Provides
//    @Singleton
//    fun provideFirebaseAnalytics() = FirebaseAnalytics.getInstance(AppController.instance)
}