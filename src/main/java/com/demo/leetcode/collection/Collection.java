package com.demo.leetcode.collection;

import com.demo.leetcode.Extension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Collection {
    public static void main(String[] args)
    {
        int x =20;
        int y =0;
        switch(x)
        {
            case 10:
                y++;
            case 20:
                y=y+2;
            case 30:
                y= y+3;
        }
        System.out.println(y);
    }

    public static void change(Person person){
        person.setName("changed");
    }
}

class Person {
    private String name;
    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

