package com.leetcode;

// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/

public class EvenDigits {
    public static int findNumbers(int[] nums) {
        int digCount = 0;
        int evenCount = 0;
        for (int i: nums) {
            if (i < 0) {
                i = i * -1;
            }

            while (i > 0) {
                digCount = 0;
                i = i/10;
                digCount++;
            }

            if (digCount % 2 == 0) {
                evenCount++;
            }
        }
        return evenCount;
    }

    public static void main(String[] args) {
        int[] arr = {437,315,322,431,686,264,442};
        System.out.println(findNumbers(arr));
    }
}
