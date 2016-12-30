package com.cytmxk.test.systemwindows.custom.fitssystemwindows;

import android.support.v4.app.Fragment;

import com.cytmxk.test.SingleFragmentActivity;

/**
 * Created by wb-cy208209 on 2016/9/28.
 */
public class FitsSystemWindowsActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new FitsSystemWindowsFragment();
    }
}
