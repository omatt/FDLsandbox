package com.omatt.fdlsandbox.components

import com.omatt.fdlsandbox.modules.deeplink.DeepLinkPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by omarmatthew on 9/16/2017.
 * DeepLinkActivity Module
 */
@Module
class DeepLinkModule {
    @Provides
    @Singleton
    fun provideMainPresenter() = DeepLinkPresenter()
}