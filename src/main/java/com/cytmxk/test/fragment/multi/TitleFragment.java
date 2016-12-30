package com.cytmxk.test.fragment.multi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;
import com.cytmxk.test.BaseFragment;
import com.cytmxk.test.R;

/**
 * Created by wb-cy208209 on 2016/9/29.
 */
public class TitleFragment extends BaseFragment {

    private View root;
    private ImageButton mLeftMenu;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_title;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = super.onCreateView(inflater, container, savedInstanceState);
        initView();
        return root;
    }

    private void initView() {
        mLeftMenu = (ImageButton) root.findViewById(R.id.id_title_left_btn);
        mLeftMenu.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getActivity(),
                        "i am an ImageButton in TitleFragment ! ",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
