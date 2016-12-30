package com.cytmxk.test.testmaterialdesign.behavior;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.cytmxk.test.BaseFragment;
import com.cytmxk.test.R;

/**
 * Created by wb-cy208209 on 2016/9/19.
 */
public class DependencyBehaviorFragment extends BaseFragment {

    private View root;
    private ImageView ivDependency;
    private ImageView ivChild;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_dependency_behavior;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = super.onCreateView(inflater, container, savedInstanceState);
        initView();
        return root;
    }

    private int mLastX;
    private int mLastY;

    private void initView() {
        ivDependency = (ImageView) root.findViewById(R.id.iv_dependency);
        ivDependency.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // 记录触摸点坐标
                        mLastX = x;
                        mLastY = y;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        // 计算偏移量
                        int offsetX = x - mLastX;
                        int offsetY = y - mLastY;
                        ivDependency.offsetLeftAndRight(offsetX);
                        ivDependency.offsetTopAndBottom(offsetY);
                        break;

                    default:
                        break;
                }
                return true;
            }
        });
        ivChild = (ImageView) root.findViewById(R.id.iv_child);
        ivChild.postDelayed(new Runnable() {
            @Override
            public void run() {
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams)ivChild.getLayoutParams();
                final DependencyBehavior dependencyBehavior = (DependencyBehavior) layoutParams.getBehavior();
                dependencyBehavior.setInitDisX(ivDependency.getLeft() - ivChild.getLeft());
            }
        }, 100);
    }
}
