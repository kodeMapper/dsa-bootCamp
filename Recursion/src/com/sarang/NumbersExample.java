package com.sarang;

public class NumbersExample {

    // Write a function that takes a number as a input and prints it
    // print first 5 numbers: 1 2 3 4 5

    public static void main(String[] args) {
        print1(1);
    }

    static void print1(int n) {
        System.out.println(n);   // 1
        print2(2);
    }

    static void print2(int n) {
        System.out.println(n);  // 2
        print3(3);
    }

    static void print3(int n) {
        System.out.println(n); // 3
        print4(4);
    }

    static void print4(int n) {
        System.out.println(n); // 4
        print5(5);
    }

    static void print5(int n) {
        System.out.println(n); // 5
    }


    /*

        1. While the function is not finished execution, it will remain in the stack
        2. When a function finishes the execution, it is removed from the stack and the flow of the program is restored to where the function has been called.

     */
}
