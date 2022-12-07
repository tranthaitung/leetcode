package com.demo.leetcode.Thread;

import com.demo.leetcode.Extension;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {


    static class Runnable1 implements Runnable {
        private Lock lock1 = null;
        private Lock lock2 = null;

        public Runnable1(Lock lock1, Lock lock2) {
            this.lock1 = lock1;
            this.lock2 = lock2;
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            // -------------------------- dead lock -----------------
//            synchronized(lock1) {
//                System.out.println(threadName + " locked Lock1");
//                lock1.lock();
//
//                Util.sleep(100);
//
//                synchronized(lock2) {
//                    lock2.lock();
//                    System.out.println(threadName + " locked Lock2");
//                    Util.sleep(100);
//                }
//                System.out.println(threadName + " unlock Lock2");
//                lock2.unlock();
//            }
//            System.out.println(threadName + " unlock Lock1");
//            lock1.unlock();
            // -------------------------- dead lock -----------------

            // -------------------------- avoid dead lock -----------------
            synchronized(lock1) {
                System.out.println(threadName + " locked Lock1");
                lock1.lock();
                Extension.sleep(100);
            }
            System.out.println(threadName + " unlock Lock1");
            lock1.unlock();

            synchronized(lock2) {
                lock2.lock();
                System.out.println(threadName + " locked Lock2");
                Extension.sleep(100);
            }
            System.out.println(threadName + " unlock Lock2");
            lock2.unlock();
            // -------------------------- avoid dead lock -----------------
        }
    }

    static class Runnable2 implements Runnable {
        private Lock lock1 = null;
        private Lock lock2 = null;

        public Runnable2(Lock lock1, Lock lock2) {
            this.lock1 = lock1;
            this.lock2 = lock2;
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            // -------------------------- dead lock -----------------
//            synchronized(lock2) {
//                System.out.println(threadName + " locked Lock2");
//                lock2.lock();
//
//                Util.sleep(100);
//
//                synchronized(lock1) {
//                    lock1.lock();
//                    System.out.println(threadName + " locked Lock1");
//                    Util.sleep(100);
//                }
//                System.out.println(threadName + " unlock Lock1");
//                lock1.unlock();
//            }
//            System.out.println(threadName + " unlock Lock2");
//            lock2.unlock();
            // -------------------------- dead lock -----------------

            // -------------------------- avoid dead lock -----------------
            synchronized(lock2) {
                System.out.println(threadName + " locked Lock2");
                lock2.lock();
                Extension.sleep(100);
            }
            System.out.println(threadName + " unlock Lock2");
            lock2.unlock();

            synchronized(lock1) {
                lock1.lock();
                System.out.println(threadName + " locked Lock1");
                Extension.sleep(100);
            }
            System.out.println(threadName + " unlock Lock1");
            lock1.unlock();
            // -------------------------- avoid dead lock -----------------
        }
    }
}

class DeadLockMain {
    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();
        Runnable runnable1 = new DeadLock.Runnable1(lock1, lock2);
        Runnable runnable2 = new DeadLock.Runnable2(lock1, lock2);

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
    }
}

