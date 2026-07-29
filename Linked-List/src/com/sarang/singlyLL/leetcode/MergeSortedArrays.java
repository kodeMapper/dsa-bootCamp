package com.sarang.singlyLL.leetcode;

import java.util.Arrays;

public class MergeSortedArrays {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0; i<nums1.length; i++) {
            if(nums1[i] == 0 && i>m-1) {
                int temp = i;
                for(int j=0; j<n; j++) {
                    nums1[temp] = nums2[j];
                    temp++;
                }

                break;
            }
        }

        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;

        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
