package com.ces.cesproject.ui.activities;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.ces.cesproject.viewmodel.BaseViewModel;
import com.ces.cesproject.viewmodel.IView;


/**
 * The type Base activity.
 *
 * @param <B> the type parameter
 * @param <T> the type parameter
 */
public abstract class BaseActivity<B extends ViewDataBinding, T extends BaseViewModel> extends FragmentActivity implements IView {

    /**
     * The View model.
     */
    protected T viewModel;
    /**
     * The Binding.
     */
    B binding;

    /**
     * ViewModel must be initialized before bindView() is called
     *
     * @param layout layout for the activity
     */
    protected final void bindView(int layout) {
        if (viewModel == null) {
            throw new IllegalStateException("viewModel must not be null and should be injected via activityComponent().inject(this)");
        }
        binding = DataBindingUtil.setContentView(this, layout);
    }

    @Override
    protected void onStop() {
        super.onStop();
        viewModel.clearSubscriptions();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.dispose();
        viewModel.detach();
    }

    @Override
    public void error(Throwable e) {
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void error() {
        Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
    }


}
