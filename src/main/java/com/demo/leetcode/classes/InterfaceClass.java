package com.demo.leetcode.classes;

public interface InterfaceClass {
    //private int isActionable = 0; ==> Modifier 'private' not allowed here interface does now have state

    public void wish();

    public static void main(String[] args) {
        InterfaceClass Iclass = new InterfaceClass() {
            @Override
            public void wish() {
                System.out.println("Hello world!");
            }
        };
        Iclass.wish();
    }
}

