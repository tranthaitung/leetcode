package com.demo.leetcode.classes;


import java.io.FileNotFoundException;
import java.io.IOException;

class TestException extends Exception
{
}
public class Test
{
    public static void m1() throws Exception
    {
        System.out.print("A");
        throw new TestException();
    }
    public static void main(String[] args)
    {
        try
        {
            m1();
        }
        catch (Exception e)
        {
            System.out.println("B");
        }
        finally
        {
            System.out.println("C");
        }

    }
}