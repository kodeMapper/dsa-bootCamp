package com.easy_questions;

public class ProductOfDigits {
    // same as sumOfDigits

    public static void main(String[] args) {
        System.out.println(prod(12532));
    }

    static int prod(int n) {
        if(n == 0) {
            return 0;
        }
        if(n==1) {
            return 1;
        }

        int rem = n % 10;
        return rem * prod(n/10);
    }
}
