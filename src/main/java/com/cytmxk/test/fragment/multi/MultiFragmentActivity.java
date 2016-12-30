package com.cytmxk.test.fragment.multi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import com.cytmxk.test.R;

/**
 * Created by wb-cy208209 on 2016/9/29.
 */
public class MultiFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_use);
        initView();
    }

    private void initView() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment titleFragment = fm.findFragmentById(R.id.fragment_title);
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        if (null == titleFragment) {
            titleFragment = new TitleFragment();
            fragmentTransaction.add(R.id.fragment_title, titleFragment);
        }
        Fragment contentFragment = fm.findFragmentById(R.id.fragment_content);
        if (null == contentFragment) {
            contentFragment = new ContentFragment();
            fragmentTransaction.add(R.id.fragment_content, contentFragment);
        }
        fragmentTransaction.commit();
    }
}
