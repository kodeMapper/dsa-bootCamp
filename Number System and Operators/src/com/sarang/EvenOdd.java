package com.sarang;

public class EvenOdd {

    public static void main(String[] args) {
        int n = 37;
        System.out.println("The number is Odd: " + evenOdd(n));
    }

    static boolean evenOdd(int n) {
        return (n & 1) == 1;
    }
}
