package com.sarang;


/*
    logic: a ^ a = 0
    also keep in mind that the operation ^ follows commutative property.
    hence, [2^2 ^ 3^3 ^ 4^4 ^ 6 ]
 */

public class FindUnique {
    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 4, 2, 6, 4 };
        System.out.println(find(arr));
    }

    static int find(int[] arr) {
        int unique = 0;

        for(int n: arr) {
            unique = unique ^ n;
        }

        return unique;
    }
}
