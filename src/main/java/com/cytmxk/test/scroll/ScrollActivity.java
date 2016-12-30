package com.cytmxk.test.scroll;

import android.support.v4.app.Fragment;

import com.cytmxk.test.SingleFragmentActivity;

/**
 * Created by chenyang on 16/6/25.
 */
public class ScrollActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new ScrollFragment();
    }
}
