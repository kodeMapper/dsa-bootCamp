package com.sarang;

public class CountSetBits {

    public static void main(String[] args) {
        int n = 45;
        System.out.println(Integer.toBinaryString(n));

        System.out.println("Count = " + setBits(n));
    }

    static int setBits(int n) {
        int count = 0;

        while (n > 0) {
            count++;
            n = n - (n & (-n));

            // n = n & (n-1)
        }
        return count;
    }
}
