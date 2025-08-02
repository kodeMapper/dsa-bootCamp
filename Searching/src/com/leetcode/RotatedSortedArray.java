package com.leetcode;

/*
        "AMAZON" and "GOOGLE"
        https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 */

public class RotatedSortedArray {


    // here is the case when there are no duplicate elements

    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases possible
            // 1
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            // 2
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            // 3
            if (arr[mid] <= arr[start]) {
                // ignore the elements after mid (because they all will be smaller then the start. and we have to search for pivot/max element)
                end = mid - 1;
            }

            // 4
            if (arr[mid] > arr[start]) {
                start = mid + 1;
            }
        }
        return -1;
    }

    static int search(int[] nums, int target) {

        // we have found pivot. now we are tying to get answer using pivot.
        // 3 cases will be there
        int pivot = findPivot(nums);

        // if we didn't find a pivot, it means the array is not rotated
        if (pivot == -1) {
            // simple binary search
            return check(nums, target, 0, nums.length - 1);
        }

        // if pivot is found, then you have got 2 ascending sorted arrays.

        // 1
        if (nums[pivot] == target) {
            return pivot;
        }

        // 2
        if (target >= nums[0]) {
            return check(nums, target, 0, pivot - 1);
        }

        // 3
        return check(nums, target, pivot + 1, nums.length - 1);
    }

    static int check(int[] arr, int target, int start, int end) {

        while (start <= end) {
//            int midInx = (start + end) / 2;   might be possible that (start + end) exceed the int range
            int mid = start + (end - start) / 2;

            if (target > arr[mid]) {
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                // answer found
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findPivot(arr));
    }
}
