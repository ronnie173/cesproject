package com.ces.cesproject.di.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * The type App module.
 */
@Module
public class AppModule {

  private Application mApplication;

  /**
   * Instantiates a new App module.
   *
   * @param mApplication the m application
   */
  public AppModule(Application mApplication) {
    this.mApplication = mApplication;
  }

  /**
   * Provides application application.
   *
   * @return the application
   */
  @Provides
  @Singleton
  Application providesApplication() {
    return mApplication;
  }

}
