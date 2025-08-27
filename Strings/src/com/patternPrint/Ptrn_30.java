package com.patternPrint;

public class Ptrn_30 {

    static void print(int n) {
        for (int row = 1; row <= n; row++) {

            for (int space = 0; space < n-row; space++) {
                System.out.print("  ");
            }

            for (int col = row; col >= 1; col--) {
                System.out.print(col + " ");
            }
            for (int col = 2; col <= row; col++) {
                System.out.print(col + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        print(5);
    }
}
