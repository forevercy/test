package com.cytmxk.test.systemwindows.dimming;

import android.support.v4.app.Fragment;
import com.cytmxk.test.SingleFragmentActivity;

/**
 * Created by wb-cy208209 on 2016/9/21.
 */
public class DimmingActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new DimmingFragment();
    }
}
