package com.cytmxk.test.testmaterialdesign.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by wb-cy208209 on 2016/9/19.
 */
public class DependencyBehavior extends CoordinatorLayout.Behavior<View> {

    private int initDisX = 0;

    public DependencyBehavior() {
    }

    public DependencyBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setInitDisX(int initDisX) {
        this.initDisX = initDisX;
        Log.d("chenyang", "setInitDisX initDisX = " + this.initDisX);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof ImageView;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        Log.d("chenyang", "onDependentViewChanged initDisX = " + initDisX + ", dependency.getLeft() - child.getLeft() = " + (dependency.getLeft() - child.getLeft()));
        int offsetX = (dependency.getLeft() - child.getLeft()) - initDisX;
        int offsetY = dependency.getTop() - child.getTop();
        Log.d("chenyang", "onDependentViewChanged offsetX = " + offsetX + ", offsetY = " + offsetY);
        child.offsetLeftAndRight(offsetX);
        child.offsetTopAndBottom(offsetY);
        return true;
    }
}
