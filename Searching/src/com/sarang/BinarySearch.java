package com.sarang;

public class BinarySearch {

//    Make sure that, your array is sorted. (also check ascending or descending)
    static boolean check(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;
        while (start <= end) {
//            int midInx = (start + end) / 2;   might be possible that (start + end) exceed the int range
            int mid = start + (end - start) / 2;

            if (target > arr[mid]) {
                start = mid + 1;
            }

            else if (target < arr[mid]){
                end = mid - 1;
            }

            else {
                // answer found
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,65};
        System.out.println(check(arr, 4));
    }
}
