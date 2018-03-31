package com.ces.cesproject.viewmodel;

/**
 * View part of MVVM, the activities and fragment implement this
 * and is used for interaction between ViewModel and Activities/Fragments
 */

public interface IView {

    void error(Throwable e);

    void error();
}
