package com.sarang;

public class RotationCount {

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

    public static void main(String[] args) {
        int[] arr = {15, 18, 2, 3, 6, 12};
        int count = findPivot(arr) + 1;
        System.out.println("Number of times the Array is Rotated: " + count);
    }
}
