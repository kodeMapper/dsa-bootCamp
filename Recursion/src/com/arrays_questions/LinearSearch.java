package com.arrays_questions;

public class LinearSearch {

    public static void main(String[] args) {
        int[] arr = {4,8,6,2,45,9,5,6,8,423};
        System.out.println(search(arr, 11, 0));
    }

    static boolean search(int[] arr, int target, int index) {
        if(index == arr.length-1) {
            return false;
        }
        return arr[index] == target || search(arr, target, index+1);
    }
}
