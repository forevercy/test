package com.cytmxk.test.fragment.single;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.cytmxk.test.R;

/**
 * Created by wb-cy208209 on 2016/10/26.
 */
public class MainActivity extends SingleFragmentActivity implements FirstFragment.OnButtonClickListener, SecondFragment.OnButtonClickListener {

    @Override
    protected Fragment createFragment() {
        FirstFragment firstFragment = FirstFragment.newInstance("FirstFragment");
        firstFragment.setOnButtonClickListener(this);
        return firstFragment;
    }


    @Override
    public void onButtonClick1() {
        SecondFragment secondFragment = SecondFragment.newInstance("SecondFragmnet");
        secondFragment.setOnButtonClickListener(this);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentContainer);
        if (null != fragment) {
            fragmentManager.beginTransaction().replace(R.id.fragmentContainer, secondFragment)
                    .addToBackStack("").commit();
        }
    }

    @Override
    public void onButtonClick2() {
        ThreeFragment threeFragment = new ThreeFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentContainer);
        if (null != fragment) {
            fragmentManager.beginTransaction().add(R.id.fragmentContainer, threeFragment)
                    .addToBackStack("").commit();
        }
    }
}
