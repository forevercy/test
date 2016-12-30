package com.cytmxk.test.thread.api;

/**
 * Created by chenyang on 2016/12/23.
 */

public class TestThread {

    public void testIsAlive() {
        Thread1 thread1 = new Thread1();
        System.out.println("testIsAlive1: thread1.isAlive() = " + thread1.isAlive());
        thread1.start();
        System.out.println("testIsAlive2: thread1.isAlive() = " + thread1.isAlive());
    }
}
