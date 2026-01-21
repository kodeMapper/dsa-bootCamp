package com.arrays_questions;

import java.util.ArrayList;

public class ReturnArraylist_InFnCall {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,4};
        int target = 4;
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(find(arr, target, 0, list));
    }

    static ArrayList<Integer> find(int[] arr, int target, int index, ArrayList<Integer> list) {
        if(index == arr.length) return list;
        if(arr[index] == target) {
            list.add(index); // target found --> add to the list
        }

        return find(arr ,target, index+1, list);
    }
}
