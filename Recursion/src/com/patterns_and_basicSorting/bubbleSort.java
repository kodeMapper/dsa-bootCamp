package com.patterns_and_basicSorting;

import java.util.Arrays;

public class bubbleSort {

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        sort(arr, arr.length-1, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr, int row, int col) {
        if(row==0) return;

        if(col < row) {
            if(arr[col] > arr[col+1]) {
                //swap

                int temp = arr[col];
                arr[col] = arr[col+1];
                arr[col+1] = temp;
            }

            sort(arr, row, col+1);
        } else {
            sort(arr, row-1, 0);
        }
    }
}
