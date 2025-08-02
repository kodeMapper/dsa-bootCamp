package com.leetcode;

/*
    Find position of an element in a sorted array of infinite numbers (we don't know the size of array)   ---> GFG article.
    https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
    "AMAZON"
 */


public class InfiniteArr {
    /*
        Approach --> as the array is sorted, we can apply binary search. But we don't know the size of array hence don't know the start and end index.
        So, at first we will find start and end index and over that chunk, we will apply binary search.
        Start from small chunk upto large one by increasing the size by 2. (Exact opposite of binary search approach. We were dividing the array in binary search. here, we start from small and increasing the size by 2 times. Hence log(n) will be the complexity which is same as binary search)
     */

    static int startEndFind(int[] arr, int target) {
        // find the range
        // start with the range of 2
        int start = 0;
        int end = 1;

        // condition of target lie in the range that --
        while (target > arr[end]) {
            // double the size
            int newStart = end + 1; // we created new start because, we needed the original start in future (line 28)
            // newEnd =  (previous end) + sizeOfBox * 2
            end = end + (end - start + 1) * 2;
            start = newStart;
        }
        return BinarySearch(arr, target, start, end);
    }

    static int BinarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
//            int mid = (start + end) / 2;   might be possible that (start + end) exceed the int range
            int mid = start + (end - start) / 2;

            if (target > arr[mid]) {
                start = mid + 1;
            }

            else if (target < arr[mid]){
                end = mid - 1;
            }

            else {
                // answer found
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,6,8,10,67,68,69,78,79,80,91,93};
        int target = 79;
        System.out.println(startEndFind(arr, target));
    }
}
