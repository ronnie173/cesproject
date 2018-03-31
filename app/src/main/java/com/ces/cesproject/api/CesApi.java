package com.ces.cesproject.api;

import com.ces.cesproject.data.DataItems;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * The interface Ces api.
 */
public interface CesApi {
    /**
     * Gets data. Using retrofit here with rxjava to get the data from the datasource
     *
     * @return the data
     */
    @GET("bins/fwra7")
    Observable<List<DataItems>> getData();
}
