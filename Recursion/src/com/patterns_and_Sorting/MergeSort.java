package com.patterns_and_Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8,3,4,12,5,6};
        System.out.println(Arrays.toString(sort(arr)));
    }

    static int[] sort(int[] arr) {
        if(arr.length == 1) return arr;

        int mid = arr.length / 2;
        int[] left = sort(Arrays.copyOfRange(arr, 0, mid)); // exclusive (does not contain mid)
        int[] right = sort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    static int[] merge(int[] first, int[] second) {

        int[] mix = new int[first.length + second.length];

        int i=0; // for first arr traversal
        int j=0; // for second arr traversal
        int k=0; // for mix arr traversal

        while( i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }

        // it might possible that some elements are remaining of any of the two arrays. append them at the end

        while (i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }

        while (j < second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }

        return mix;
    }
}

// this method creates multiple copies (objects) of the array which increases space complexity. So we use in-place method, which modifies the existing array. We pass only indices instead of copy of the array.
