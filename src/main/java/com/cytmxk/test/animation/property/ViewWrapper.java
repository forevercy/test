package com.cytmxk.test.animation.property;

import android.view.View;

/**
 * Created by chenyang on 16/8/17.
 */
public class ViewWrapper {

    private View view;

    public ViewWrapper(View view) {
        this.view = view;
    }

    public int getHeight(){
        return view.getLayoutParams().height;
    }

    public void setHeight(int height){
        view.getLayoutParams().height = height;
        view.requestLayout();
    }
}
