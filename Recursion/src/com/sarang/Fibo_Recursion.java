package com.sarang;

import java.util.Scanner;

public class Fibo_Recursion {
    // find nth fibonaci number

    public static void main(String[] args) {
        System.out.print("Enter number: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n + "th" + " fibonaci number is: " + fibo(n));
    }

    static long fibo(int n) {
        // base condition
        if(n==0) {
            return 0;
        } else if(n==1 || n==2) {
            return 1;
        } else {
            return fibo(n-1) + fibo(n-2);
        }
    }
}
