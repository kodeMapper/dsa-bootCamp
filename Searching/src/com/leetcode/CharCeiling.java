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
        return letters[start % letters.length];
    }

    public static void main(String[] args) {
        char[] arr = {'x', 'x', 'y', 'y'};
        char target = 'z';
        System.out.println(charCeiling(arr, target));
    }
}
