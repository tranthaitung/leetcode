package com.demo.leetcode.passbyvalue;

public class PassByValue {
    public static void main(String[] args) {
        Dog aDog = new Dog("Max");
        Dog oldDog = aDog;
        int value = 0;

        // we pass the object to foo
        foo(aDog, value);
        // aDog variable is still pointing to the "Max" dog when foo(...) returns
        aDog.getName().equals("Max"); // true
        aDog.getName().equals("Fifi"); // false
        //aDog == oldDog; // true
    }

    public static void foo(Dog d, int value) {
        d.getName().equals("Max"); // true
        // change d inside of foo() to point to a new Dog instance "Fifi"
//        d = new Dog("Fifi");
//        d.getName().equals("Fifi"); // true
        d.setName("Fifi");
        value = 10;
    }
}

