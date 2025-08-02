package com.sarang;

import java.util.Arrays;
import java.util.Scanner;

public class MultiDimension {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
            1 2 3
            4 5 6
            7 8 9
         *//*

        int[][] mat = new int[3][3];  we must mention the NUMBER OF ROWS. Column number is not necessary to state.
      */
//        Or
        int[][] mat = {
                {1,2,3},
                {4,5},
                {6,7,8,9}
        };
        /*
            Here, similarly of arrays, memory allocation may not continuous.
         */

        /*
            {{1,2,3},
             {4,5},
             {6,7,8,9}}
         */

        int[][] arr2D = new int[3][2];
        for (int i = 0; i < arr2D.length; i++) {
            for (int j = 0; j < arr2D[i].length; j++) {
//                System.out.print("Enter: "+arr2D[i][j]);
                arr2D[i][j] = sc.nextInt();
            }
        }
//        Output:
        for (int i = 0; i < arr2D.length; i++) {
            for (int j = 0; j < arr2D[i].length; j++) {
                System.out.print(arr2D[i][j]+" ");
            }
            System.out.println();
        }
//        other way of printing:
        for (int i = 0; i < arr2D.length; i++) {
            System.out.println(Arrays.toString(arr2D[i]));
        }
//        Another way:
        for(int[] i: arr2D) {
            System.out.println(Arrays.toString(i));
        }
    }
}
