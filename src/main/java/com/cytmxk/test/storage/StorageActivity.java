package com.cytmxk.test.storage;

import android.support.v4.app.Fragment;
import com.cytmxk.test.SingleFragmentActivity;

/**
 * Created by chenyang on 2017/3/17.
 */

public class StorageActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new StorageFragment();
    }
}
