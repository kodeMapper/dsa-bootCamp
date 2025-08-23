package com.leetcode;

/*
    https://leetcode.com/problems/first-missing-positive/
    "AMAZON"
 */
public class FirstMissingPositive {
    static int missingNumber(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            // if index != elem --> swap

            if(nums[i] > 0 && nums[i] <= nums.length && i != nums[i]) {
                int temp;
                temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
            else i++;
        }

        // search for the first missing number
        for (i = 0; i < nums.length; i++) {
            if(nums[i] != i+1) {
                return i+1;
            }
        }
        return nums.length+1;
    }
}
