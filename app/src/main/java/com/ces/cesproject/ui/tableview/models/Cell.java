package com.ces.cesproject.ui.tableview.models;

import com.evrencoskun.tableview.filter.IFilterableModel;
import com.evrencoskun.tableview.sort.ISortableModel;

/**
 * Created by jeromeraymond on 3/29/18.
 * Package name is com.ces.cesproject.ui.tableviewmodels
 * Project name is cesproject
 */

public class Cell implements ISortableModel, IFilterableModel {
    private String mId;
    private Object mData;
    private String mFilterKeyword;


    public Cell(String id, Object data) {
        this.mId = id;
        this.mData = data;
        this.mFilterKeyword = String.valueOf(data);
    }


    /**
     * This is necessary for sorting process.
     * See ISortableModel
     */
    @Override
    public String getId() {
        return mId;
    }

    /**
     * This is necessary for sorting process.
     * See ISortableModel
     */
    @Override
    public Object getContent() {
        return mData;
    }


    public Object getData() {
        return mData;
    }

    public void setData(String data) { mData = data; }

    public String getFilterKeyword() {
        return mFilterKeyword;
    }

    public void setFilterKeyword(String filterKeyword) {
        this.mFilterKeyword = filterKeyword;
    }

    @Override
    public String getFilterableKeyword() {
        return mFilterKeyword;
    }
}
