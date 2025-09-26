package com.sarang;

public class PowerofNumber {

    public static void main(String[] args) {
        int base = 3;
        int power = 6;
        System.out.println("Answer: " + calc(base, power));
    }

    static int calc(int b, int p) {
        int ans = 1;

        while(p > 0) {
            if ((p & 1) == 1) {
                ans *= b;
            }

            b *= b;
            p = p >> 1;
        }

        return ans;
    }
}
