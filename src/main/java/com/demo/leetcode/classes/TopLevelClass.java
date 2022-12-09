package com.demo.leetcode.classes;

public class TopLevelClass { // static not allowed here, the top-level class does not have outer class =>

    private static String msg = "GeeksForGeeks";
    public class Bar {
        // Non-static innner class
    }

    public static class NestedStaticClass {
        // Static inner class
        public void printMessage()
        {
            // Try making 'message' a non-static
            // variable, there will be compiler error
            System.out.println("Message from nested static class: " + msg);
        }
    }

    public static void main(String[] args) {
        new TopLevelClass(); // this is ok
        new TopLevelClass.NestedStaticClass(); // this is ok
        // new TopLevelClass.Bar(); // does not compile!

        TopLevelClass f = new TopLevelClass();
        TopLevelClass.Bar bar = f.new Bar(); //this works, but don't do this
    }

}
