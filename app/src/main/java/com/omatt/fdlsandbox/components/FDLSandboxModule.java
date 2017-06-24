package com.omatt.fdlsandbox.components;

import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.omatt.fdlsandbox.utils.AppController;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by omarmatthew on 6/24/17.
 */
@Module
class FDLSandboxModule {
    private final AppController app;
    public FDLSandboxModule(AppController app) {
        this.app = app;
    }

    /**
     * Provide injectable FirebaseAuth instance
     * @return FirebaseAuth
     */
    @Provides
    @Singleton
    FirebaseDynamicLinks provideFirebaseDynamicLinks(){
        return FirebaseDynamicLinks.getInstance();
    }
}
