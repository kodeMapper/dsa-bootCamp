package com.leetcode;

// https://leetcode.com/problems/find-smallest-letter-greater-than-target/

public class CharCeiling {

    static char charCeiling(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target > letters[mid]) {
                start = mid + 1;
            }

            else {
                end = mid - 1;
            }
        }
        if (start == letters.length)
            return letters[0]; // this if condition can be use instead of that modulo thing. but as the function wants a return statement, we needed to keep that modulo statement, though it has no use as its work is done by the if check.
        return letters[start % letters.length];
    }

    public static void main(String[] args) {
        char[] arr = {'x', 'x', 'y', 'y'};
        char target = 'z';
        System.out.println(charCeiling(arr, target));
    }
}
