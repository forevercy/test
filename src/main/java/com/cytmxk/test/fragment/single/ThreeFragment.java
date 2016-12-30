package com.cytmxk.test.fragment.single;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.cytmxk.test.BaseFragment;
import com.cytmxk.test.R;

/**
 * Created by wb-cy208209 on 2016/10/26.
 */
public class ThreeFragment extends BaseFragment implements View.OnClickListener {

    private View root;
    private Button nextBtn;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_three;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = super.onCreateView(inflater, container, savedInstanceState);
        initView();
        return root;
    }

    private void initView() {
        nextBtn = (Button) root.findViewById(R.id.button_next);
        nextBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (R.id.button_next == v.getId()) {
            Toast.makeText(getActivity(), "ThreeFragment", Toast.LENGTH_LONG).show();
        }
    }
}
