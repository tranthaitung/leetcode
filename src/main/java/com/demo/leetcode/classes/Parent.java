package com.demo.leetcode.classes;


public abstract class Parent {

    public abstract void abstractMethod1();

    public void nonAstractMethod(){

    }


}

class Child extends Parent {

    @Override
    public void abstractMethod1() {

    }
}
