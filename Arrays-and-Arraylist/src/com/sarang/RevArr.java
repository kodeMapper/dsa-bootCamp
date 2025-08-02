package com.sarang;

import java.util.Arrays;

public class RevArr {
    static void swap(int[] arr, int toSwapIdx, int swapWithIdx) {
        int temp = arr[toSwapIdx];
        arr[toSwapIdx] = arr[swapWithIdx];
        arr[swapWithIdx] = temp;
    }
    static void revArr(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        revArr(arr);
    }
}
