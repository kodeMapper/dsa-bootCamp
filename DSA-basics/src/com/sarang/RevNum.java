package com.sarang;

import java.util.Scanner;

public class RevNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int revNum = 0;
        while(num > 0) {
            int rem = num % 10;
            num = num/10;
            revNum = revNum * 10 + rem;
        }
        System.out.println(revNum);
    }
}
