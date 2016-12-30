package com.cytmxk.test.fragment.single;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.cytmxk.test.BaseFragment;
import com.cytmxk.test.R;

/**
 * Created by wb-cy208209 on 2016/10/26.
 */
public class FirstFragment extends BaseFragment implements View.OnClickListener {

    private static final String KEY_ENTER_STRING = "KEY_ENTER_STRING";

    private View root;
    private EditText enterET;
    private Button nextBtn;

    private String enterString = "";

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_first;
    }

    public static FirstFragment newInstance(String enter) {
        FirstFragment firstFragment = new FirstFragment();
        Bundle arguments = new Bundle();
        arguments.putString(KEY_ENTER_STRING, enter);
        firstFragment.setArguments(arguments);
        return  firstFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = super.onCreateView(inflater, container, savedInstanceState);
        initData();
        initView();
        return root;
    }

    private void initData() {
        enterString = getArguments().getString(KEY_ENTER_STRING, "");
    }

    private void initView() {
        enterET = (EditText) root.findViewById(R.id.edittext_enter);
        enterET.setText(enterString);
        nextBtn = (Button) root.findViewById(R.id.button_next);
        nextBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (R.id.button_next == v.getId()) {
            if (null != onButtonClickListener) {
                onButtonClickListener.onButtonClick1();
            }
        }
    }

    private OnButtonClickListener onButtonClickListener;
    public void setOnButtonClickListener(OnButtonClickListener onButtonClickListener) {
        this.onButtonClickListener = onButtonClickListener;
    }
    public interface OnButtonClickListener {
        void onButtonClick1();
    }
}
