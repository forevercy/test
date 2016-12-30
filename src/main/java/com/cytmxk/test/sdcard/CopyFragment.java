package com.cytmxk.test.sdcard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.cytmxk.test.BaseFragment;
import com.cytmxk.test.R;
import com.cytmxk.utils.storage.AssetCopyer;
import java.io.IOException;

/**
 * Created by chenyang on 2016/11/14.
 */

public class CopyFragment extends BaseFragment implements View.OnClickListener {

    private View root;
    private Button copyToSdcard;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_copy;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = super.onCreateView(inflater, container, savedInstanceState);
        initView();
        return root;
    }

    private void initView() {
        copyToSdcard = (Button) root.findViewById(R.id.button_copy_to_sdcard);
        copyToSdcard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (R.id.button_copy_to_sdcard == v.getId()) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        new AssetCopyer(getActivity()).copy();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
