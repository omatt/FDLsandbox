package com.omatt.fdlsandbox.components;

import com.omatt.fdlsandbox.utils.AppController;

import dagger.Module;

/**
 * Created by omarmatthew on 6/24/17.
 */
@Module
class FDLSandboxModule {
    private final AppController app;
    public FDLSandboxModule(AppController app) {
        this.app = app;
    }
}
