package com.omatt.fdlsandbox.components

import com.google.firebase.analytics.FirebaseAnalytics
import com.omatt.fdlsandbox.AppController
import com.omatt.fdlsandbox.modules.MainPresenter
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

    @Provides
    @Singleton
    fun provideFirebaseAnalytics() = FirebaseAnalytics.getInstance(AppController.instance)
}