
package com.ces.cesproject.data;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;


/**
 * The type Data items.
 */
@AutoValue
public abstract class DataItems {

    /**
     * Id string.
     *
     * @return the string
     */
    @SerializedName("id")
    public abstract String id();

    /**
     * Vendor vendor.
     *
     * @return the vendor
     */
    @SerializedName("vendor")
    public abstract Vendor vendor();

    /**
     * Stock code string.
     *
     * @return the string
     */
    @SerializedName("stockCode")
    public abstract String stockCode();

    /**
     * Desc string.
     *
     * @return the string
     */
    @SerializedName("desc")
    public abstract String desc();

    /**
     * Type adapter type adapter.
     *
     * @param gson the gson
     * @return the type adapter
     */
// The public static method returning a TypeAdapter<DataItems> is what
    // tells auto-value-gson to create a TypeAdapter for DataItems.
    public static TypeAdapter<DataItems> typeAdapter(Gson gson) {
        return new AutoValue_DataItems.GsonTypeAdapter(gson);
    }

}
