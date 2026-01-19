package com.easy_questions;

public class SumOfDigits {
// fn(1349) --> fn(134) + 9 (remainder)

    public static void main(String[] args) {
        System.out.println(sum(1349));
    }

    static int sum(int n) {
        if (n == 0) {
            return 0;
        }

        int rem = n % 10;
        return rem + sum(n/10);
    }
}
