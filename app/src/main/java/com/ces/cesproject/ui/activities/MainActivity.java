package com.ces.cesproject.ui.activities;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;

import com.ces.cesproject.MyApplication;
import com.ces.cesproject.R;
import com.ces.cesproject.api.CesApi;
import com.ces.cesproject.data.DataItems;
import com.ces.cesproject.databinding.ActivityMainBinding;
import com.ces.cesproject.ui.fragments.MainFragment;
import com.ces.cesproject.viewmodel.MainActivityView;
import com.ces.cesproject.viewmodel.MainActivityViewModel;

import java.util.List;

import javax.inject.Inject;

/**
 * The type Main activity.
 */
public class MainActivity extends BaseActivity<ActivityMainBinding, MainActivityViewModel> implements MainActivityView {
    private final String TAG = MainActivity.class.getSimpleName();

    /**
     * The Ces api.
     */
    @Inject
    CesApi cesApi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getComponent().inject(this);
        viewModel = new MainActivityViewModel(cesApi);
        viewModel.attach(this);
        bindView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.activity_container, new
                    MainFragment(), MainFragment.class.getSimpleName()).commit();
        }

        hideNavigationBar();
    }


    @Override
    protected void onStart() {
        super.onStart();
        viewModel.fetchItems();
    }

    @Override
    public void load(List<DataItems> items) {
        FragmentManager fm = getSupportFragmentManager();
        MainFragment mainFragment = (MainFragment) fm.findFragmentById(R.id.activity_container);
        mainFragment.populatedTableView(items);

    }


    private void hideNavigationBar() {

        final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View
                .SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View
                .SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        // This work only for android 4.4+
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            getWindow().getDecorView().setSystemUiVisibility(flags);

            // Code below is to handle presses of Volume up or Volume down.
            // Without this, after pressing volume buttons, the navigation bar will
            // show up and won't hide
            final View decorView = getWindow().getDecorView();
            decorView.setOnSystemUiVisibilityChangeListener(visibility -> {
                if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                    decorView.setSystemUiVisibility(flags);
                }
            });
        }

    }

}


