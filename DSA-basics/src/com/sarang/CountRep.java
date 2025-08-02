package com.sarang;

import java.util.Scanner;

public class CountRep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a large number: ");
        int num = sc.nextInt();
        System.out.print("Enter a digit for which you have to count its occurance in the number: ");
        int digit = sc.nextInt();
        int digCount = 0;
        int totDig = 0;
        int temp = num;
        while (temp > 0) {
            int rem = temp % 10; // it gives the last digit of that number
            if (rem == digit) {
                digCount++;
            }
            temp = temp / 10;
            totDig++;
        }
        System.out.println("Total number of "+digit+"'s in "+num+" is: "+digCount);
        System.out.println("Total digits in "+num+" is: "+totDig);
    }
}
