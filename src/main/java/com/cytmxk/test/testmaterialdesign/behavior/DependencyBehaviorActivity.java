package com.cytmxk.test.testmaterialdesign.behavior;

import android.support.v4.app.Fragment;

import com.cytmxk.test.SingleFragmentActivity;

/**
 * Created by wb-cy208209 on 2016/9/19.
 */
public class DependencyBehaviorActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new DependencyBehaviorFragment();
    }
}
