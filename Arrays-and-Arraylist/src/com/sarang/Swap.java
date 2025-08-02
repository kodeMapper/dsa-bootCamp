package com.sarang;

import java.util.Arrays;

public class Swap {
//    Swapping two elements using indices

    static void swap(int[] arr, int toSwapIdx, int swapWithIdx) {
        int temp = arr[toSwapIdx];
        arr[toSwapIdx] = arr[swapWithIdx];
        arr[swapWithIdx] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,5,9,7};
        System.out.println("Initially: "+Arrays.toString(arr));
        swap(arr, 2,4);
        System.out.print("After swapping: "+Arrays.toString(arr));
    }
}
