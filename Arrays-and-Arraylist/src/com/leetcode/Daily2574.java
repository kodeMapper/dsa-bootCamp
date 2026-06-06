package com.leetcode;

import java.util.Arrays;

public class Daily2574 {
    public static int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] ls = new int[n];
        int[] rs = new int[n];
        int lsum = nums[0];
        int rsum = 0;
        int[] answer = new int[n];

        for(int i=0; i<n; i++) {
            rsum += nums[i];
        }

        for(int i=0; i<n; i++) {
            if(i==0) {
                ls[i] = 0;
                continue;
            }
            if(i==1) {
                ls[i] = nums[i-1];
                continue;
            }
            if(i > 1) {
                lsum = lsum + nums[i-1];
                ls[i] = lsum;
            }
        }

        for(int i=0; i<n; i++) {
            if(i==(n-1)) {
                rs[i] = 0;
                continue;
            }
            if(i != (n-1)) {
                rsum = rsum - nums[i];
                rs[i] = rsum;
            }
        }

        for(int i=0; i<n; i++) {
            answer[i] = Math.abs(ls[i] - rs[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {10, 4, 8, 3};
        System.out.println(Arrays.toString(leftRightDifference(arr)));
    }
}
