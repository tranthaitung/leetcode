package com.demo.leetcode;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class Extension {
    public static void print(String message) {
        System.out.println("Thread " + Thread.currentThread()
                .getName() + ": " + message);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void tryLock(Lock lock, long millis) {
        try {
            lock.tryLock(millis, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean tryLock(Lock lock) {
        return lock.tryLock();
    }
}