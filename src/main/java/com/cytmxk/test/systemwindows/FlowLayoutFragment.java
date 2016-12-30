package com.cytmxk.test.systemwindows;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.cytmxk.test.R;

/**
 * Created by chenyang on 16/6/18.
 */
public class FlowLayoutFragment extends Fragment {

    private RelativeLayout root;
    private FlowLayout flowLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = (RelativeLayout) inflater.inflate(R.layout.fragment_flow_layout, container, false);
        //initView();
        return root;
    }

    private void initView() {

        flowLayout = (FlowLayout) root.findViewById(R.id.flow_layout);
        RelativeLayout.LayoutParams flowLayoutParams = (RelativeLayout.LayoutParams) flowLayout.getLayoutParams();

        // 生成一个状态栏大小的矩形
        // 获得状态栏高度
        int resourceId = getActivity().getResources().getIdentifier("status_bar_height", "dimen", "android");
        int statusBarHeight = getActivity().getResources().getDimensionPixelSize(resourceId);

        // 绘制一个和状态栏一样高的矩形
        View statusView = new View(getActivity());
        statusView.setId(R.id.status_bar_view);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                statusBarHeight);
        statusView.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        // 添加 statusView 到根布局的顶端
        root.addView(statusView, 0, params);
        flowLayoutParams.addRule(RelativeLayout.BELOW, R.id.status_bar_view);
        flowLayout.setLayoutParams(flowLayoutParams);
    }
}
