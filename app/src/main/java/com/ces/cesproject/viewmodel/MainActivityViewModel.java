package com.ces.cesproject.viewmodel;


import com.ces.cesproject.api.CesApi;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * The type Main activity view model.
 */
public class MainActivityViewModel extends BaseViewModel<MainActivityView> {


    @Inject
    CesApi cesApi;

    /**
     * Instantiates a new Main activity view model.
     *
     * @param cesApi the ces api
     */
    public MainActivityViewModel(CesApi cesApi) {
        this.cesApi = cesApi;
    }

    /**
     * Fetch items. using rxjava here
     */
    public void fetchItems() {
        compositeDisposable.add(cesApi.getData()
                .subscribeOn(Schedulers.computation())
                .map(dataResponses -> dataResponses)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(dataResponse -> view.load(dataResponse)));

    }


}
