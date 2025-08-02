package com.sarang;

import java.util.Scanner;

public class Fibo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the index of fibo series and get its value: ");
        int num = sc.nextInt();
        int a = 0;
        int b = 1;

        for (int i = 2; i <= num ; i++) {
            int temp = b;
            b = a + b;
            a = temp;
        }

        System.out.println(b);
    }
}
