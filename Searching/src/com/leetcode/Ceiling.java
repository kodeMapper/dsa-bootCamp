package com.leetcode;

public class Ceiling {

/*    Ceiling number --> smallest element in the array which is greater than or equal to the target
        arr = {1,2,4,5,9,10}   (sorted)
        target = 6
        ceiling(arr, target)    --> 9
*/

    static int ceiling(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid]) {
                return target;
            }
            else if (target > arr[mid]) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        if (target > arr[arr.length - 1]) {
            return -1;
        }
        return arr[start];
    }

    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,4,6,8,9,10,12,15};
        int target = 7;
        System.out.println(ceiling(arr, target));
    }
}
