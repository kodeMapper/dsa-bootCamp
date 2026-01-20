package com.easy_questions;

public class RevNum {
    /*
        rev(3572) --> rem (2) + rev(357) update place value each time
     */

    public static void main(String[] args) {
        revOf_1(3572);
        System.out.println(sum);
        System.out.println(revOf_2(49268));
        System.out.println(revOf_3(694752));
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

    // we needed to pass something extra in arg (placeVal in this case), hence use helper function (vid - 47:00 min)
    // sometimes u might need some *additional variables* in the args, in that case, make helper function
    static int revOf_3(int n) {
        int digits = (int)(Math.log10(n) + 1);
        return helper(n, digits);
    }

    private static int helper(int n, int digits) {
        if (n%10 == n) {
            return n;
        }

        int rem = n%10;
        return rem* (int)(Math.pow(10, digits-1)) + helper(n/10, digits-1);
    }
}
