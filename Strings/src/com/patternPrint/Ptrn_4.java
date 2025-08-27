package com.patternPrint;

public class Ptrn_4 {

    static void print(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        print(5);

        /*
            1
            12
            123
            1234
            12345
         */
    }
}
