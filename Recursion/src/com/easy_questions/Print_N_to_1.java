package com.easy_questions;

// to revise internal implementation - https://youtu.be/9OsMG4fI4OY?si=KsD0yygjQbsmpdmS

public class Print_N_to_1 {

    public static void main(String[] args) {
        print(5);
        System.out.println();
        printRev(5);
        System.out.println();
        printBoth(5);
    }

    static void print(int n) {
        if(n==0) {
            return;
        }
        System.out.print(n + " ");
        print(n-1);
    }

    static void printRev(int n) {
        if(n==0) {
            return;
        }
        printRev(n-1);
        System.out.print(n + " ");
    }

    static void printBoth(int n) {
        if(n==0) {
            return;
        }
        System.out.print(n + " ");
        printBoth(n-1);
        System.out.print(n + " ");
    }
}
