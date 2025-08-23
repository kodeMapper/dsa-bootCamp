package com.leetcode;

/*
    https://leetcode.com/problems/missing-number/
    "AMAZON"
 */

public class MissingNumber {

    static int missingNumber(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            // if index != elem --> swap

            if(nums[i] < nums.length && i != nums[i]) {
                int temp;
                temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
            else i++;
        }

        // search for the first missing number
        for (i = 0; i < nums.length; i++) {
            if(nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] arr = {0,3,5,1,4};
        int ans = missingNumber(arr);
        System.out.println("Missing Number is " + ans);
    }
}
