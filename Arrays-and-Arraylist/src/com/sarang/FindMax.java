package com.sarang;

public class FindMax {
    static int max(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,56,4,62,10,0};
        System.out.println(max(arr));
    }
}
