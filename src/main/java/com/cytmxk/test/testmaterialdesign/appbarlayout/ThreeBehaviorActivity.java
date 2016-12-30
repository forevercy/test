package com.cytmxk.test.testmaterialdesign.appbarlayout;

import android.support.v4.app.Fragment;
import com.cytmxk.test.SingleFragmentActivity;

/**
 * Created by wb-cy208209 on 2016/11/9.
 */

public class ThreeBehaviorActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new ThreeBehaviorFragment();
    }
}
