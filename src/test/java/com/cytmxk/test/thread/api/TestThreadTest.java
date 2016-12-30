package com.cytmxk.test.thread.api;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chenyang on 2016/12/23.
 */
public class TestThreadTest {

    private  TestThread testThread;
    @Test
    public void testIsAlive() throws Exception {

        testThread = new TestThread();
        testThread.testIsAlive();
    }

}