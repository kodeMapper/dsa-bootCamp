package com.leetcode;

// https://leetcode.com/problems/find-in-mountain-array/

public class FindInMountain {

    int search(int[] arr, int target) {
        int peak = peakIndexInMountainArray(arr);
        int firstHalf = orderAgnosticBinarySearch(arr, target, 0, peak);
        if (firstHalf != -1) {
            // if the element found then return the index of it.
            return firstHalf;
        }
        // if the element is not present in the first half, then search in the second half
        int secondHalf = orderAgnosticBinarySearch(arr, target, peak+1, arr.length-1);
        return secondHalf;
    }

    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid+1]) {
                end = mid;
            }

            else {
                start = mid + 1;
            }
        }
        return start;
    }

    static int orderAgnosticBinarySearch(int[] arr, int target, int start, int end) {
        boolean isAscending = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                return mid;
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
        return -1;
    }
}
