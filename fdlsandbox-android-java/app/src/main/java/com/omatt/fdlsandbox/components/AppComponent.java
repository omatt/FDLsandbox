package com.omatt.fdlsandbox.components;

import com.omatt.fdlsandbox.modules.deeplink.DeepLinkActivity;
import com.omatt.fdlsandbox.modules.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by omarmatthew on 6/24/17.
 */

@Singleton
@Component(modules = {FDLSandboxModule.class, MainModule.class, DeepLinkModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);
    void inject(DeepLinkActivity deepLinkActivity);
}
