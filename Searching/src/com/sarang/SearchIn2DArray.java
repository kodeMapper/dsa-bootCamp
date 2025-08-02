package com.sarang;

public class SearchIn2DArray {

    static boolean search(int[][] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == target) {
                    System.out.println(i+" "+j);
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] arr2D = {
                {1,2,3},
                {4,5,67,45},
                {7,8,9,10},
                {71,82}
        };
        int target = 67;
        System.out.println(search(arr2D, target));
    }
}
