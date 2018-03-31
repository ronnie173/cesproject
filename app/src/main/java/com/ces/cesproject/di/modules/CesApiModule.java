package com.ces.cesproject.di.modules;

import com.ces.cesproject.api.CesApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * The type Ces api module.
 */
@Module
public class CesApiModule {

    /**
     * Provide retrofit ces api.
     *
     * @param retrofit the retrofit
     * @return the ces api
     */
    @Provides
    @Singleton
    CesApi provideRetrofit(Retrofit retrofit) {
        return retrofit.create(CesApi.class);
    }
}
