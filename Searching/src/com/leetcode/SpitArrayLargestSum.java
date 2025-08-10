package com.leetcode;

/*
    "GOOGLE"
    https://leetcode.com/problems/split-array-largest-sum/
 */

public class SpitArrayLargestSum {

    public static int splitArray(int[] nums, int m) {
        int start = 0;
        int end = 0;
        for (int i=0; i< nums.length; i++) {
            start = Math.max(start, nums[i]); // in the end of the loop, this will contain the max item from the array
            end = end + nums[i];
        }

        // binary search
        while(start < end) {
            // try for the middle as potential answer
            int mid = start + (end - start) / 2;

            // Calculate how many pieces we can divide this in, with this max sum
            int sum = 0;
            int pieces = 1;

            for (int elem: nums) {
                if (sum + elem > mid) {
                    // you cannot add this in this subarray, we should make new one
                    // let say we add this elem in new subarray, then sum = elem
                    sum = elem;
                    pieces++;
                }
                else {
                    sum = sum + elem;
                }
            }

            if (pieces > m) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start; // here, start = end
    }

    public static void main(String[] args) {

    }
}
