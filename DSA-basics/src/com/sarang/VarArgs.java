package com.sarang;

import java.util.Arrays;

public class VarArgs {
//    When we don't know the number of args to be passed

    static void dynamicArray(int ...v) {
        System.out.println(Arrays.toString(v));
    }

    static void diffArgs(int a, int b, String ...s) {
        System.out.println(a +" "+b+" "+ Arrays.toString(s));
    }

    public static void main(String[] args) {
        dynamicArray(1,2,66,4,65,3,22,45);
        diffArgs(2, 3, "Sarang", "Bhai", "Baburao"); // var args should be at last of args list
    }
}
