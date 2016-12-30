package com.cytmxk.test.testmaterialdesign.behavior;

import android.support.v4.app.Fragment;
import com.cytmxk.test.SingleFragmentActivity;

/**
 * Created by wb-cy208209 on 2016/11/1.
 */

public class ScrollBehaviorActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new ScrollBehaviorFragment();
    }
}
