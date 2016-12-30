package com.cytmxk.test.systemwindows;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.WindowManager;

import com.cytmxk.test.SingleFragmentActivity;

/**
 * Created by chenyang on 16/6/18.
 */
public class FlowLayoutActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new FlowLayoutFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        immerseStatusBar();
        super.onCreate(savedInstanceState);
    }

    public void immerseStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 设置状态栏透明
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }
}
