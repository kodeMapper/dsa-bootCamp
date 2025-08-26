package com.sarang;

import java.util.Arrays;

public class OutputStyles {
    public static void main(String[] args) {
        System.out.println("Everything which is passed in sout, will be treated as a String.");
        System.out.println(56); // considered as string --> goes in valueOf() method --> if not null, then goes in toString()
        // if null.toString --> NULL POINTER EXCEPTION

        System.out.println("But in case of arrays, it gives some random string due to the code written internally");
        System.out.println(new int[] {1,2,3,4,5});

        // to print it properly and nicer way, we override the toString method in println with the toString method in Arrays
        System.out.println(Arrays.toString(new int[] {1,2,3,4,5}));
    }
}
