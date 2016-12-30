package com.cytmxk.test.systemwindows.hide;

import android.support.v4.app.Fragment;
import com.cytmxk.test.SingleFragmentActivity;

/**
 * Created by wb-cy208209 on 2016/9/22.
 */
public class HideActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new HideFragment();
    }
}
