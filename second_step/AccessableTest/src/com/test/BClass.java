package com.test;

public class BClass {
    public int publicValue2;

    public void publicMethod2() {
        System.out.println("public 메서드2");
    }


    protected int protectedValue2;

    protected void protectedMethod2() {
        System.out.println("protected 메서드2");
    }


    int defaultValue2;

    void defaultMethod2() {
        System.out.println("default 메서드2");
    }


    private int privateValue2;

    private void privateMethod2() {
        System.out.println("private 메서드");
    }
}
