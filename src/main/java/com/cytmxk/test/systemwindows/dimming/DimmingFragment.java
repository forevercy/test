package com.cytmxk.test.systemwindows.dimming;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.cytmxk.test.BaseFragment;
import com.cytmxk.test.R;

/**
 * Created by wb-cy208209 on 2016/9/21.
 */
public class DimmingFragment extends BaseFragment implements View.OnClickListener {

    private View root;
    private Button btnDimSystemBars;
    private Button btnCancelDimSystemBars;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_dimming;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = super.onCreateView(inflater, container, savedInstanceState);
        initView();
        return root;
    }

    private void initView() {
        btnDimSystemBars = (Button) root.findViewById(R.id.btn_dim_system_bars);
        btnCancelDimSystemBars = (Button) root.findViewById(R.id.btn_cancel_dim_system_bars);
        btnDimSystemBars.setOnClickListener(this);
        btnCancelDimSystemBars.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (R.id.btn_dim_system_bars == v.getId()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                dimSystemBars();
            }
        } else if (R.id.btn_cancel_dim_system_bars == v.getId()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                cancelDimSystemBars();
            }
        }
    }

    private void dimSystemBars() {
        // This example uses decor view, but you can use any visible view.
        View decorView = getActivity().getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_LOW_PROFILE;
        decorView.setSystemUiVisibility(uiOptions);
    }

    private void cancelDimSystemBars() {
        View decorView = getActivity().getWindow().getDecorView();
        // Calling setSystemUiVisibility() with a value of 0 clears
        // all flags.
        decorView.setSystemUiVisibility(0);
    }
}
