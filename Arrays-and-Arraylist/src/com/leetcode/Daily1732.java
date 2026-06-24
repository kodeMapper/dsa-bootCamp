package com.leetcode;

public class Daily1732 {

    public static int largestAltitude(int[] gain) {
        int point = 0;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<gain.length; i++) {
            point = point + gain[i];
            max = Math.max(max, point);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-4,-3,-2,-1,4,3,2};
        System.out.println(largestAltitude(arr));
    }
}
