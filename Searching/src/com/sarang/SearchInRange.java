package com.sarang;

import java.util.Scanner;

public class SearchInRange {

    static boolean search(int[] arr, int start, int end, int target) {
        if (arr.length == 0) {
            return false;
        }

        for (int i = start; i <= end; i++) {
            if (arr[i] == target) {
                System.out.println("Found at index "+i);
                return true;
            }
        }
        return false;
    }

    static void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.print("Start entering the elements: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the target to search: ");
        int target = sc.nextInt();
        System.out.print("Enter start and end index for range: ");
        int start = sc.nextInt();
        int end = sc.nextInt();
        display(search(arr, start, end, target));
    }

    static void display(boolean result) {
        System.out.println(result);
    }

    public static void main(String[] args) {
        input();
    }
}
