package com.omatt.fdlsandbox.components;

import com.omatt.fdlsandbox.modules.DeepLinkPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by omarmatthew on 9/16/2017.
 * Module for DeepLinkActivity
 */
@Module
class DeepLinkModule {
    @Provides
    @Singleton
    DeepLinkPresenter provideDeepLinkPresenter(){
        return new DeepLinkPresenter();
    }
}
