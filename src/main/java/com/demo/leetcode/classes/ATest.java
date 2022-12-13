package com.demo.leetcode.classes;


abstract class AClass {

    public AClass(String paymentMethod){
        System.out.println(paymentMethod);
    }

    abstract void APrint();

    public String getInstanceVariable() {
        return instanceVariable;
    }

    public void setInstanceVariable(String instanceVariable) {
        this.instanceVariable = instanceVariable;
    }

    private String instanceVariable;
}

public class ATest extends AClass {


    public ATest(String paymentMethod) {
        super("Credit card");
    }

    @Override
    void APrint() {

    }

    public static void main(String[] args)
    {
      ATest aTest = new ATest("Credit Card");
    }
}

