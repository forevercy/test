package com.cytmxk.test.testmaterialdesign.appbarlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cytmxk.test.BaseFragment;
import com.cytmxk.test.R;

/**
 * Created by wb-cy208209 on 2016/11/8.
 */

public class SecondBehaviorFragment extends BaseFragment {

    private View root;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected int getLayoutResId() {
        return R.layout.fargment_second_behavior;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = super.onCreateView(inflater, container, savedInstanceState);
        initView();
        return root;
    }

    private void initView() {
        tabLayout = (TabLayout) root.findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("TabOne"), true);
        tabLayout.addTab(tabLayout.newTab().setText("TabTwo"));
        tabLayout.addTab(tabLayout.newTab().setText("TabThree"));

        viewPager = (ViewPager) root.findViewById(R.id.viewpager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);
    }

    public class ViewPagerAdapter extends FragmentStatePagerAdapter {

        private String[] pageTitles = new String[] {"TabOne", "TabTwo", "TabThree"};

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            SecondBehaviorVpFragment fragment = new SecondBehaviorVpFragment();
            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return pageTitles[position];
        }
    }
}
