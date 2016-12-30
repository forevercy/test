package com.cytmxk.test.messagemechanism.threadlocal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cytmxk.test.R;

/**
 * Created by chenyang on 16/8/20.
 */
public class ThreadLocalFragment extends Fragment {

    private static final String TAG = ThreadLocalFragment.class.getCanonicalName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_thread_local, container, false);
        testThreadLocal();
        return root;
    }

    public void testThreadLocal() {
        final ThreadLocal<Integer> threadLocal1 = new ThreadLocal<Integer>();
        final ThreadLocal<String> threadLocal2 = new ThreadLocal<String>();
        threadLocal1.set(5);
        threadLocal2.set("one");
        Log.d(TAG, "Thread1 threadLocal1.get() = " + threadLocal1.get());
        Log.d(TAG, "Thread1 threadLocal2.get() = " + threadLocal2.get());

        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal1.set(9);
                threadLocal2.set("two");
                Log.d(TAG, "Thread2 threadLocal1.get() = " + threadLocal1.get());
                Log.d(TAG, "Thread2 threadLocal2.get() = " + threadLocal2.get());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "Thread3 threadLocal1.get() = " + threadLocal1.get());
                Log.d(TAG, "Thread3 threadLocal2.get() = " + threadLocal2.get());
            }
        }).start();
    }
}
