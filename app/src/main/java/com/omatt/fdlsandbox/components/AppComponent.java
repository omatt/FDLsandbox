package com.omatt.fdlsandbox.components;

import com.omatt.fdlsandbox.DeepLinkActivity;
import com.omatt.fdlsandbox.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by omarmatthew on 6/24/17.
 */

@Singleton
@Component(modules = {FDLSandboxModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);
    void inject(DeepLinkActivity deepLinkActivity);
}
