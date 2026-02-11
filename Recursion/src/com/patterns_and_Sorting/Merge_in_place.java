package com.patterns_and_Sorting;

import java.util.Arrays;

public class Merge_in_place {
    public static void main(String[] args) {
        int[] arr = {8,3,4,12,5,6};
        sort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));

    }

    static void sort(int[] arr, int s, int e) {
        if(e-s == 1) return;

        int mid = (s + e) / 2;
        sort(arr, s, mid);
        sort(arr, mid, e);

        merge(arr, s, mid, e);
    }

    static void merge(int[] arr ,int s, int mid, int e) {

        int[] mix = new int[e-s];

        int i=s; // for first arr traversal
        int j=mid; // for second arr traversal
        int k=0; // for mix arr traversal

        while( i < mid && j < e) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        // it might possible that some elements are remaining of any of the two arrays. append them at the end

        while (i < mid) {
            mix[k] = arr[i];
            i++;
            k++;
        }

        while (j < e) {
            mix[k] = arr[j];
            j++;
            k++;
        }

        // modify the original array
        for (int l=0; l < mix.length; l++) {
            arr[s+l] = mix[l];
        }
    }
}
