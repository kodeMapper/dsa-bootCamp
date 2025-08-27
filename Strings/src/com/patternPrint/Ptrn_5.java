package com.patternPrint;

public class Ptrn_5 {

    static void print1(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        for (int row = 1; row <= n-1; row++) {
            for (int col = 1; col <= n-row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void print2(int n) {
        for (int row = 0; row < 2 * n; row++) {
            int totalColsInRow = row > n ? 2*n-row : row;
            for (int col = 0; col < totalColsInRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        print1(5);
        print2(5);

        /*
            *
            **
            ***
            ****
            *****
            ****
            ***
            **
            *
         */
    }
}
