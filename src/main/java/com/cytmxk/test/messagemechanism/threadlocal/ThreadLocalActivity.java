package com.cytmxk.test.messagemechanism.threadlocal;

import android.support.v4.app.Fragment;

import com.cytmxk.test.SingleFragmentActivity;

/**
 * Created by chenyang on 16/8/20.
 */
public class ThreadLocalActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new ThreadLocalFragment();
    }
}
