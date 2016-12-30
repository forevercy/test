package com.cytmxk.test.interpolator;

import android.support.v4.app.Fragment;

import com.cytmxk.test.SingleFragmentActivity;

/**
 * Created by chenyang on 16/8/16.
 */
public class InterpolatorActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new InterpolatorFragment();
    }
}
