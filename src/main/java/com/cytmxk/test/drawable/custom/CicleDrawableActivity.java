package com.cytmxk.test.drawable.custom;

import android.support.v4.app.Fragment;

import com.cytmxk.test.SingleFragmentActivity;

/**
 * Created by chenyang on 16/8/13.
 */
public class CicleDrawableActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CicleDrawableFragment();
    }
}
