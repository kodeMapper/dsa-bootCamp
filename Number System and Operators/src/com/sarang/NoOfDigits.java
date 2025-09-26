package com.sarang;

public class NoOfDigits {

    public static void main(String[] args) {
        int b = 2;
        int num = 10;
        System.out.println("Number of Digits in 10 in base 2: " + countDigits(b, num));
    }

    static int countDigits(int b, int num) {
        int count = 0;
        count = (int)(Math.log(num) / Math.log(b)) + 1;
        return count;
    }
}
