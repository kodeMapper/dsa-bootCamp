package com.sarang;

import java.util.Arrays;

public class cyclicSort {

    static void sort1(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            while(i != arr[i]-1) {
                 // if index != elem-1 --> swap
                int temp;
                temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }
    }

    static void sort2(int[] arr) {
        int i = 0;
        while(i < arr.length) {
            // if index != elem-1 --> swap

            if(i != arr[i]-1) {
                int temp;
                temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
            else i++;
        }
    }

    static void sort3(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                swap(arr, i , correct);
            } else {
                i++;
            }
        }
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,2,1,4};
//        sort1(arr);
        sort2(arr);
//        sort3(arr);
        System.out.println(Arrays.toString(arr));
    }
}
