package com.ces.cesproject;

import android.app.Application;

import com.ces.cesproject.di.component.DaggerAppComponent;
import com.ces.cesproject.di.modules.AppModule;
import com.ces.cesproject.di.modules.CesApiModule;
import com.ces.cesproject.di.modules.NetworkModule;
import com.ces.cesproject.di.component.AppComponent;

import org.reactivestreams.Subscription;

/**
 * The type My application.
 */
public class MyApplication extends Application {

    private static AppComponent component;

    /**
     * Initializing Dagger dependency injection
     *
     */
    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder()
                .cesApiModule(new CesApiModule())
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();
    }

    /**
     * Gets component.
     *
     * @return the component
     */
    public static AppComponent getComponent() {
        return component;
    }
}
