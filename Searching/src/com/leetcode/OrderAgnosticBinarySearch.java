package com.leetcode;

// When we don't know that sorting is in ascending or descending

public class OrderAgnosticBinarySearch {
    static boolean orderAgnosticBinarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        boolean isAscending = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                return true;
            }

            if (isAscending) {
                System.out.println("Ascending");
                if (target > arr[mid]) {
                    start = arr[mid] + 1;
                } else {
                    end = arr[mid] - 1;
                }
            } else {
                System.out.println("Descending");
                if (target < arr[mid]) {
                    start = arr[mid] + 1;
                } else {
                    end = arr[mid] - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 4, 3, 2, 1};
        int target = 2;
        System.out.println(orderAgnosticBinarySearch(arr, target));
    }
}
