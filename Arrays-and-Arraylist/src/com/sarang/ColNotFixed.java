package com.sarang;

public class ColNotFixed {
    public static void main(String[] args) {
        int[][] mat = {
                {1,2,3,4},
                {5,6},
                {7,8,9}
        };

        for (int rows = 0; rows < mat.length; rows++) {
            for (int col = 0; col < mat[rows].length; col++) {
                System.out.print(mat[rows][col]+" ");
            }
            System.out.println();
        }
    }
}
