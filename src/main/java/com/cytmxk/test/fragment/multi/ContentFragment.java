package com.cytmxk.test.fragment.multi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cytmxk.test.BaseFragment;
import com.cytmxk.test.R;

/**
 * Created by wb-cy208209 on 2016/9/29.
 */
public class ContentFragment extends BaseFragment {

    private View root;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_content;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = super.onCreateView(inflater, container, savedInstanceState);
        return root;
    }
}
