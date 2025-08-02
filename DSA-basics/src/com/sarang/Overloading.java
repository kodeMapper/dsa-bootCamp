package com.sarang;

public class Overloading {
    static int sum(int a, int b) {
        return(a+b);
    }

    static String sum(String s1, String s2) {
        return (s1+s2);
    }

    public static void main(String[] args) {
        System.out.println(sum(2, 3));
        System.out.println(sum("Hello ", "World"));
    }

/*
    Overloading method calls decides at compile time. For overloading, method name should same and atleast one of the following should diff:
            1. No. of args
            2. Type of args
*/
}
