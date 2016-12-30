package com.cytmxk.test.systemwindows.hide;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import com.cytmxk.test.BaseFragment;
import com.cytmxk.test.R;

/**
 * Created by wb-cy208209 on 2016/9/22.
 */
public class HideFragment extends BaseFragment implements View.OnClickListener {

    private View root;
    private Button btnHideStatusBar;
    private Button btnCancelHideStatusBar;
    private Button btnHideNavigationBar;
    private Button btnCancelHideNavigationBar;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_hide;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = super.onCreateView(inflater, container, savedInstanceState);
        initView();
        return root;
    }

    private void initView() {
        btnHideStatusBar = (Button) root.findViewById(R.id.btn_hide_status_bar);
        btnCancelHideStatusBar = (Button) root.findViewById(R.id.btn_cancel_hide_status_bar);
        btnHideNavigationBar = (Button) root.findViewById(R.id.btn_hide_navigation_bar);
        btnCancelHideNavigationBar = (Button) root.findViewById(R.id.btn_cancel_hide_navigation_bar);
        btnHideStatusBar.setOnClickListener(this);
        btnCancelHideStatusBar.setOnClickListener(this);
        btnHideNavigationBar.setOnClickListener(this);
        btnCancelHideNavigationBar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (R.id.btn_hide_status_bar == v.getId()) {
            hideStatusBar();
        } else if (R.id.btn_cancel_hide_status_bar == v.getId()) {
            cancelHideStatusBar();
        } else if (R.id.btn_hide_navigation_bar == v.getId()) {
            hideNavigationBar();
        } else if (R.id.btn_cancel_hide_navigation_bar == v.getId()) {
            cancelHideNavigationBar();
        }
    }

    private void hideStatusBar() {
        // If the Android version is lower than Jellybean, use this call to hide
        // the status bar.
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            View decorView = getActivity().getWindow().getDecorView();
            // Hide the status bar.
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }

    private void cancelHideStatusBar() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }

    private void hideNavigationBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            View decorView = getActivity().getWindow().getDecorView();
            // Hide both the navigation bar and the status bar.
            // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
            // a general rule, you should design your app to hide the status bar whenever you
            // hide the navigation bar.
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }

    private void cancelHideNavigationBar() {

    }
}
