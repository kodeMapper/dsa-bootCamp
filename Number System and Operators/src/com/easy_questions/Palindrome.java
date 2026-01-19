package com.easy_questions;

public class Palindrome {

    public static void main(String[] args) {
        int num = 1234321;
        int rev = checkRev(num);

        System.out.println(num == rev);
    }

    static int checkRev(int n) {
        if(n==0) {
            return 0;
        }

        int rem = n % 10;
        int digits = (int)(Math.log10(n) + 1);
        int placeVal = (int)(Math.pow(10, digits-1));
        --digits;
        return (rem * placeVal) + checkRev(n/10);
    }
}
