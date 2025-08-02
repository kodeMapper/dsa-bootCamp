package com.sarang;

import java.util.Scanner;

public class Armstrong {
//    Print all the 3 digits armstrong numbers

    static void armstrong() {
        for (int num = 100; num <= 999; num++) {
            int rem = 0, cube = 0, sum = 0;
            int temp = num;

            while (temp>0) {
                rem = temp % 10; // took the last digit of num
                cube = rem*rem*rem; // cube of that digit
                sum = sum + cube; // added the cube to sum
                temp = temp/10; // deleted the last digit
            }

            if(sum == num) {
                System.out.print(num+"\t");
            }
        }
    }

    static boolean check(int num) {
        int rem = 0, cube = 0, sum = 0;
        int temp = num;

        while (temp>0) {
            rem = temp % 10; // took the last digit of num
            cube = rem * rem * rem; // cube of that digit
            sum = sum + cube; // added the cube to sum
            temp = temp / 10; // deleted the last digit
        }
        return sum == num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        armstrong(); // print all the 3 digit armstrong numbers
        System.out.print("\nEnter a number to check: \t");
        int num = sc.nextInt();
        System.out.println(check(num)); // check that armstrong or not
    }
}
