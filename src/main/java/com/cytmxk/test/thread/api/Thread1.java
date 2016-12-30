package com.cytmxk.test.thread.api;

/**
 * Created by chenyang on 2016/12/20.
 */

public class Thread1 extends Thread {

    @Override
    public void run() {
        System.out.println("Thread1 run1 isAlive() = " + isAlive());
        super.run();
        System.out.println("Thread1 run2 isAlive() = " + isAlive());

    }
}
