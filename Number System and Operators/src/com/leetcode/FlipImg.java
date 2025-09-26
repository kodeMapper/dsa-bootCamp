package com.leetcode;

import java.util.Arrays;

/*
    GOOGLE
    number - 832
 */
public class FlipImg {
    public static void main(String[] args) {
        int[][] arr = {{1,1,0},{1,0,1},{0,0,0}};
        flipImage(arr);
    }

    static void flipImage(int[][] arr) {
        for(int i=0; i< arr.length; i++) {
            int start = 0;
            int end = arr[i].length -1;
            while (start <= end) {
                int temp = arr[i][start] ^ 1;
                arr[i][start] = arr[i][end] ^ 1;
                arr[i][end] = temp;

                start++;
                end--;
            }
        }

        print(arr);
    }

    static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
