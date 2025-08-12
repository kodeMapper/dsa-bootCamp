package com.sarang;

import java.util.Arrays;

public class selectionSort {

    static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // select the max item in the remaining array and swap with last index of the ongoing iteration

            int lastIndex = arr.length - i - 1; // for i=0, last index would be arr.length-1
            int maxIndex = findMax(arr, 0, lastIndex);
            swap(arr, maxIndex,lastIndex);
        }
    }

    static int findMax(int[] arr, int start, int end) {
        int max = start;
        for (int i = start; i <= end; i++) {
            if(arr[max] < arr[i]) {
                max = i;
            }
        }
        return max;
    }

    static void swap(int[] arr, int first, int second) {
        int temp;
        temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 10, 8, 9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
