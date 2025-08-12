package com.sarang;

import java.util.Arrays;

public class bubbleSort {

    static void sort(int[] arr) {
        // run the outer loop (iteration) n-1 times
        boolean swapped;
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            // inner loop will run length-i times (because each time we will get sorted elements, so no need to run the loop over them)
            // we can run N times, but its not needed as we are getting sorted part with each iteration
            for(int j = 1; j < arr.length - i; j++) {

                // if no swap occured here, means the array is sorted already. Hence no need of further iterations(i)
                if(arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;
                }
            }

            // if we did not swap for a particular iteration(i), then array is already sorted. Hence stop the program
            if(!swapped) {
                break;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 10, 8, 9};
        sort(arr);
    }
}
