package com.arrays_questions;

public class SortedOrNot {
    public static void main(String[] args) {
        int[] arr = {1,2,1,5,6};

        System.out.println(check(arr));
    }

    static boolean check(int[] arr) {
        return helper(arr, 0);
    }

    static boolean helper(int[] arr, int index) {
        if(index == arr.length-1) {
            return true;
        }
        return (arr[index] < arr [index+1]) && helper(arr, index+1);
    }
}

/*
    No need of helper here. coz, we are not returning any number. we can do directly as well. just call helper from main with (arr, 0)
 */