package com.ces.cesproject.viewmodel;
import com.ces.cesproject.data.DataItems;

import java.util.List;


/**
 * The interface Main activity view.
 */
public interface MainActivityView extends IView {

    /**
     * Load.
     *
     * @param items the items
     */
    void load(List<DataItems> items);

}
