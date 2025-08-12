package com.sarang;

import java.util.Arrays;

public class bubbleSort {

    static void swap(int[] arr) {
        // run the outer loop (iteration) n-1 times

        for (int i = 0; i < arr.length; i++) {

            // inner loop will run length-i times (because each time we will get sorted elements, so no need to run the loop over them)
            // we can run N times, but its not needed as we are getting sorted part with each iteration
            for(int j = 1; j < arr.length - i; j++) {

                //swap
                if(arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 10, 8, 9};
        swap(arr);
    }
}
