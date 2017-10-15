package com.omatt.fdlsandbox.components

import com.omatt.fdlsandbox.modules.inappbrowser.InAppBrowserPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by omarmatthew on 10/14/2017.
 * InAppBrowserActivity module
 */
@Module
class InAppBrowserModule {
    @Provides
    @Singleton
    fun provideInAppBrowserPresenter() = InAppBrowserPresenter()
}