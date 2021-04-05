package com.rakib.util;

public class ThreadSleep {
    public static void sleep(int second){
        try {
            Thread.sleep(second* 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
