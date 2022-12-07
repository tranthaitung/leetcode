package com.demo.leetcode.Thread;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.demo.leetcode.Extension.*;

public class LiveLock {
    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {
        LiveLock livelock = new LiveLock();
        Thread thread1 = new Thread(livelock::operation1, "T1");
        Thread thread2 = new Thread(livelock::operation2, "T1");

        thread1.start();
        //thread2.start();
    }

    public void operation1() {
        while (true) {
            tryLock(lock1, 1000);
            print("lock1 acquired, trying to acquire lock2.");
            sleep(1000);

            if (tryLock(lock2)) {
                print("lock2 acquired.");
            } else {
                print("cannot acquire lock2, releasing lock1.");
                lock1.unlock();
                continue;
            }

            print("executing first operation.");
            break;
        }
        lock2.unlock();
        lock1.unlock();
    }

    public void operation2() {
        while (true) {
            tryLock(lock2, 1000);
            print("lock2 acquired, trying to acquire lock1.");
            sleep(1000);

            if (tryLock(lock1)) {
                print("lock1 acquired.");
            } else {
                print("cannot acquire lock1, releasing lock2.");
                lock2.unlock();
                continue;
            }

            print("executing second operation.");
            break;
        }
        lock1.unlock();
        lock2.unlock();
    }
}