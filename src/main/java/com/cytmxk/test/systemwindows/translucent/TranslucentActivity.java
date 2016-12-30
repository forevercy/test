package com.cytmxk.test.systemwindows.translucent;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.WindowManager;
import com.cytmxk.test.SingleFragmentActivity;

/**
 * Created by wb-cy208209 on 2016/9/23.
 */
public class TranslucentActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new TranslucentFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        translucentStatusBar();
    }

    private void translucentStatusBar() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //透明状态栏
            //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            //Android 5.x开始需要把颜色设置透明，否则导航栏会呈现系统默认的浅灰色
            getWindow().setStatusBarColor(getResources().getColor(android.R.color.transparent));
        } else if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }
}
