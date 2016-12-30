package com.cytmxk.test.drawable.custom;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cytmxk.test.R;

/**
 * Created by chenyang on 16/8/13.
 */
public class CicleDrawableFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_cicle_drawable, container, false);
        initView(root);
        return root;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void initView(View root) {
        ImageView ivCicleDrawable = (ImageView) root.findViewById(R.id.iv_test_cicle_drawable);
        ivCicleDrawable.setBackground(new CicleDrawable());
    }
}
