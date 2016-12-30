package com.cytmxk.test.thread.api;

import android.util.Log;

/**
 * Created by chenyang on 2016/12/20.
 */

public class Thread3 extends Thread {
    private static final String TAG = "Thread3";

    @Override
    public void run() {
        super.run();
        Log.d(TAG, "run: Thread3");
    }
}
