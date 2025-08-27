package com.patternPrint;

public class Ptrn_28 {

    static void print(int n) {
        for (int row = 0; row <= 2*n-1; row++) {
            int totalColsInRow = row > n? 2*n-row : row;

            int noOfSpaces = n - totalColsInRow;
            for (int s = 0; s < noOfSpaces; s++) {
                System.out.print(" ");
            }

            for (int col = 0; col < totalColsInRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        print(5);
    }
}
