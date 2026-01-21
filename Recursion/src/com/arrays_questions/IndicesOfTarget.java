package com.arrays_questions;

import java.util.ArrayList;

public class IndicesOfTarget {

    public static void main(String[] args) {
        int[] arr = {3,2,1,9,5,7,9,2,6,1};
        find(arr, 2, 0);
        System.out.println(list);
    }

    static ArrayList<Integer> list = new ArrayList<>();

    static int findIndexFromStart(int[] arr, int target, int index) {
        if(index == arr.length-1) return -1;
        if(arr[index] == target) return index;

        else return findIndexFromStart(arr ,target, index+1);
    }

    static int findIndexFromLast(int[] arr, int target, int index) {
        if(index == -1) return -1;
        if(arr[index] == target) return index;

        else return findIndexFromLast(arr, target, index-1);
    }

    static void find(int[] arr, int target, int index) {
        if(index == arr.length-1) return;
        if(arr[index] == target) {
            list.add(index); // target found --> add to the list
        }

        find(arr ,target, index+1);
    }

}
