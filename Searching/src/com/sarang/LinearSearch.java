package com.sarang;

import java.util.Scanner;

public class LinearSearch {

    static boolean check(int[] arr, int target) {
        for (int elem : arr) {
            if (elem == target) {
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
        display(check(arr, target));
    }

    static void display(boolean result) {
        System.out.println(result);
    }

    public static void main(String[] args) {
        input();
    }
}

/*
    Time complexity:
    Best -> O(1)
    Worst -> O(n)    n is array size

 */