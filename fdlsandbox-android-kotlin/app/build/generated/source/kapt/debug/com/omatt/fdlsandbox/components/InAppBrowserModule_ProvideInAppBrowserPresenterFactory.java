// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.omatt.fdlsandbox.components;

import com.omatt.fdlsandbox.modules.inappbrowser.InAppBrowserPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class InAppBrowserModule_ProvideInAppBrowserPresenterFactory
    implements Factory<InAppBrowserPresenter> {
  private final InAppBrowserModule module;

  public InAppBrowserModule_ProvideInAppBrowserPresenterFactory(InAppBrowserModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public InAppBrowserPresenter get() {
    return Preconditions.checkNotNull(
        module.provideInAppBrowserPresenter(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<InAppBrowserPresenter> create(InAppBrowserModule module) {
    return new InAppBrowserModule_ProvideInAppBrowserPresenterFactory(module);
  }
}
