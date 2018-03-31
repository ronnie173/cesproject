package com.ces.cesproject.di.modules;

import com.ces.cesproject.BuildConfig;
import com.ces.cesproject.api.AutoValueGsonFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * The type Network module.
 */
@Module
public class NetworkModule {

  /**
   * Provides gson gson.
   *
   * @return the gson
   */
  @Provides
  @Singleton
  Gson providesGson() {
    return new GsonBuilder().serializeNulls().setLenient().registerTypeAdapterFactory(AutoValueGsonFactory.create()).create();
  }

  /**
   * Provide ok http client ok http client.
   *
   * @return the ok http client
   */
  @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
      HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
      interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor).build();
    }

  /**
   * Provide gson converter factory gson converter factory.
   *
   * @param gson the gson
   * @return the gson converter factory
   */
  @Provides
  @Singleton
  GsonConverterFactory provideGsonConverterFactory(Gson gson) {
    return GsonConverterFactory.create(gson);
  }


  /**
   * Provide retrofit retrofit.
   *
   * @param okHttpClient the ok http client
   * @param factory      the factory
   * @return the retrofit
   */
  @Provides
  @Singleton
  Retrofit provideRetrofit(OkHttpClient okHttpClient, GsonConverterFactory factory) {
    return new Retrofit.Builder()
      .baseUrl(BuildConfig.END_POINT)
      .client(okHttpClient)
      .addConverterFactory(factory)
      .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
      .build();
  }
}

