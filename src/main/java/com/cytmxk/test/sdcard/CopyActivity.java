package com.cytmxk.test.sdcard;

import android.support.v4.app.Fragment;
import com.cytmxk.test.SingleFragmentActivity;

/**
 * Created by chenyang on 2016/11/14.
 */

public class CopyActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CopyFragment();
    }
}
