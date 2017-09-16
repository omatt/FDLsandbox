package com.omatt.fdlsandbox.components;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.omatt.fdlsandbox.modules.DeepLinkPresenter;
import com.omatt.fdlsandbox.modules.MainPresenter;
import com.omatt.fdlsandbox.utils.AppController;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by omarmatthew on 6/24/17.
 * App Module
 */
@Module
public class FDLSandboxModule {
    private final AppController app;
    public FDLSandboxModule(AppController app) {
        this.app = app;
    }

    /**
     * Provide dependency injectable FirebaseAuth instance
     * @return FirebaseAuth
     */
    @Provides
    @Singleton
    FirebaseDynamicLinks provideFirebaseDynamicLinks(){
        return FirebaseDynamicLinks.getInstance();
    }

    /**
     * Provide dependency injectable FirebaseAnalytics instance
     * @return FirebaseAnalytics
     */
    @Provides
    @Singleton
    FirebaseAnalytics provideFirebaseAnalytics(){
        return FirebaseAnalytics.getInstance(app);
    }
}
