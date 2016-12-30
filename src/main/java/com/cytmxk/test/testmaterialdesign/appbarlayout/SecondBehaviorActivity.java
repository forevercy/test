package com.cytmxk.test.testmaterialdesign.appbarlayout;

import android.support.v4.app.Fragment;
import com.cytmxk.test.SingleFragmentActivity;

/**
 * Created by wb-cy208209 on 2016/11/8.
 */

public class SecondBehaviorActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new SecondBehaviorFragment();
    }
}
