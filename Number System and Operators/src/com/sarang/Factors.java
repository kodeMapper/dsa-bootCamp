package com.sarang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Factors {

    // Time: O(n)
    static void factors1(int n) {
        for (int i = 1; i <= n; i++) {
            if(n % i == 0) {
                System.out.print(i + " ");
            }
        }
    }

    // Time: O(sqrt(n))
    static void factors2(int n) {
        for (int i = 1; i < Math.sqrt(n) ; i++) {
            if(n % i == 0) {
                if(n/i == i) {
                    System.out.println(i);
                } else {
                    System.out.print(i + " " + n / i + " ");
                }
            }
        }
    }

    // sorted
    static void factors3(int n) {
        ArrayList <Integer> list = new ArrayList<>();

        for (int i = 1; i < Math.sqrt(n) ; i++) {
            if(n % i == 0) {
                if(n/i == i) {
                    System.out.println(i);
                } else {
                    System.out.print(i + " ");
                    list.add(n/i); // descending
                }
            }
        }

//        Collections.reverse(list);
//        System.out.println(list);

        // or

        for (int i = list.size()-1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }


    public static void main(String[] args) {
//        factors1(20);
//        factors2(20);
        factors3(20);
    }
}
