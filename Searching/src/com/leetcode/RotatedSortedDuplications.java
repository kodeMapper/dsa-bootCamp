package com.leetcode;

/*
    This is the case when the array contains some duplicate elements. ao we need to eliminate those duplications to reach to our final answer.
 */

public class RotatedSortedDuplications {
    static int findPivotWithDuplicates(int[] arr) {
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
            // if start, middle and end elements are equal, then skipp the duplicates
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                // skip the duplicates
                // NOTE: What if these elements at start and end were the pivots? So check for them before eliminating them.

                // check if the start is pivot or not
                if (arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                // check if the end is pivot or not
                if (arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            }
            // left side is sorted hence pivot at right
            else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end] )) {
                start = mid + 1;
            }
            end = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,9,2,2,2,2};
        System.out.println(findPivotWithDuplicates(arr));
    }
}
