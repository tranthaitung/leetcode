package com.demo.leetcode.InnerClass;

class OuterClass {
    class InnerClass{

    }

    static class StaticInnerClass{}
}


class Main {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass inner = outerClass.new InnerClass();

    }
}
