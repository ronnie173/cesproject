package com.ces.cesproject.di.component;

import com.ces.cesproject.di.modules.CesApiModule;
import com.ces.cesproject.ui.activities.MainActivity;
import com.ces.cesproject.di.modules.AppModule;
import com.ces.cesproject.di.modules.NetworkModule;
import javax.inject.Singleton;
import dagger.Component;

/**
 * The interface App component.
 */
@Singleton
@Component(modules = {AppModule.class, NetworkModule.class, CesApiModule.class})
public interface AppComponent {
  /**
   * Inject.
   *
   * @param activity the activity
   */
  void inject(MainActivity activity);
}
