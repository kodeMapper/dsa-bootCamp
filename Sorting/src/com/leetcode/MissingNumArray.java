package com.leetcode;
/*
    https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
    "GOOGLE"
 */

import java.util.ArrayList;
import java.util.List;

public class MissingNumArray {

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        int i = 0;
        while(i < nums.length) {
            // if index != elem-1 --> swap

            if(nums[i] != nums[nums[i]-1]) {
                int temp;
                temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
            else i++;
        }

        // find missing
        List<Integer> ans = new ArrayList<>();
        for (i = 0; i < nums.length; i++) {
            if(nums[i] != i+1) {
                ans.add(i+1);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        System.out.println("Missing numbers array: " + findDisappearedNumbers(arr));
    }
}