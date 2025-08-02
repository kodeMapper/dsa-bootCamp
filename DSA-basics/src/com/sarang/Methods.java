package com.sarang;

import java.util.Scanner;

public class Methods {
    static int sum(int a, int b) {
        int ans = a + b;
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Answer: " + sum(a, b));
    }
}
