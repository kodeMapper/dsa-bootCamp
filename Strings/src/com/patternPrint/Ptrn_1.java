package com.patternPrint;

public class Ptrn_1 {

    static void print(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        print(5);

        /*
            *****
            *****
            *****
            *****
            *****
         */
    }
}
