package com.omatt.fdlsandbox.components;

import com.omatt.fdlsandbox.modules.main.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by omarmatthew on 9/16/2017.
 * Module for MainActivity
 */
@Module
class MainModule {
    @Provides
    @Singleton
    MainPresenter provideMainPresenter(){
        return new MainPresenter();
    }
}
