package com.cytmxk.test.systemwindows.immersive;

import android.support.v4.app.Fragment;
import com.cytmxk.test.SingleFragmentActivity;

/**
 * Created by wb-cy208209 on 2016/9/23.
 */
public class ImmersiveActivity extends SingleFragmentActivity{

    @Override
    protected Fragment createFragment() {
        return new ImmersiveFragment();
    }
}
