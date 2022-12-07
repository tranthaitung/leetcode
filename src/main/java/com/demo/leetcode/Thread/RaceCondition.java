package com.demo.leetcode.Thread;

import com.demo.leetcode.Extension;

public class RaceCondition {

    static class Counter implements Runnable {
        private int c = 0;

        public void increment() {
            Extension.sleep(10);
            c++;
        }

        public void decrement() {
            c--;
        }

        public int getValue() {
            return c;
        }

        @Override
        public void run() {
            synchronized (this) { // remove this line will cause the race condition
                this.increment();
                System.out.println(Thread.currentThread().getName() + " Increment " + this.getValue());

                this.decrement();
                System.out.println(Thread.currentThread().getName() + " Decrement " + this.getValue());
            }

        }
    }
}

class RaceConditionMain {
    public static void main(String[] args) {
        RaceCondition.Counter counter = new RaceCondition.Counter();
        Thread t1 = new Thread(counter, "Thread-1");
        Thread t2 = new Thread(counter, "Thread-2");
        Thread t3 = new Thread(counter, "Thread-3");
        t1.start();
        t2.start();
        t3.start();
    }
}

