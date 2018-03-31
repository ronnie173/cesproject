package com.ces.cesproject.api;

import com.google.gson.TypeAdapterFactory;
import com.ryanharter.auto.value.gson.GsonTypeAdapterFactory;

/**
 * The type Auto value gson factory.
 */
@GsonTypeAdapterFactory
public abstract class AutoValueGsonFactory implements TypeAdapterFactory{
  /**
   * Create type adapter factory.
   *
   * @return the type adapter factory
   */
  public static TypeAdapterFactory create() {
    return new AutoValueGson_AutoValueGsonFactory();
  }

}
