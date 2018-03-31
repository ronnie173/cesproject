
package com.ces.cesproject.data;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * The type Vendor.
 */
@AutoValue
public abstract class Vendor {

    /**
     * Code string.
     *
     * @return the string
     */
    @SerializedName("code")
    public abstract String code();

    /**
     * Name string.
     *
     * @return the string
     */
    @SerializedName("name")
    public abstract String name();

    /**
     * Supress string.
     *
     * @return the string
     */
    @SerializedName("supress")
    public abstract String supress();


    /**
     * Type adapter type adapter.
     *
     * @param gson the gson
     * @return the type adapter
     */
// The public static method returning a TypeAdapter<Vendor> is what
    // tells auto-value-gson to create a TypeAdapter for Vendor.
    public static TypeAdapter<Vendor> typeAdapter(Gson gson) {
        return new AutoValue_Vendor.GsonTypeAdapter(gson);
    }
}
