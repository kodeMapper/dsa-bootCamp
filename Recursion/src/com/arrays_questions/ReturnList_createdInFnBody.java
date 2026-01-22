package com.arrays_questions;

import java.util.ArrayList;

public class ReturnList_createdInFnBody {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,4};
        int target = 4;
        System.out.println(find(arr, target, 0));
    }

    static ArrayList<Integer> find(int[] arr, int target, int index) {

        ArrayList<Integer> list = new ArrayList<>();

        if(index == arr.length) return list;

        // this will contain answer for that function call only.
        if(arr[index] == target) {
            list.add(index); // target found --> add to the list
        }

        ArrayList<Integer> ansFromBelowCalls = find(arr ,target, index+1);
        list.addAll(ansFromBelowCalls);

        return list;
    }
}
