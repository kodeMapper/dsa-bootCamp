package com.easy_questions;

public class RevNum {
    /*
        rev(3572) --> rem (2) + rev(357) update place value each time
     */

    public static void main(String[] args) {
        revOf_1(3572);
        System.out.println(sum);
        System.out.println(revOf_2(49268));
    }

    static int sum = 0;

    static void revOf_1(int n) {
        if(n==0) {
            return;
        }
        int rem = n % 10;
        sum = sum * 10 + rem;
        revOf_1(n/10);
    }

    static int revOf_2(int n) {
        if(n==0) {
            return 0;
        }

        int rem = n % 10;
        int digits = (int)(Math.log10(n) + 1);
        int placeVal = (int)(Math.pow(10, digits-1));
        --digits;
        return (rem * placeVal) + revOf_2(n/10);
    }
}
