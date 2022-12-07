package com.demo.leetcode.solid;

import static com.demo.leetcode.Extension.print;

public class LiskovSubstitution {

    public void main(String[] args) {
        Apple apple = new Orange();
        print(apple.getColor()); // wired output => violate LiskovSub
    }

    class Apple {
        String getColor() {
            return "Red";
        }
    }

    class Orange extends Apple {
        @Override
        String getColor() {
            return "Orange";
        }
    }
}
