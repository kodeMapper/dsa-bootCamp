package com.sarang;

import java.util.Arrays;

public class Passing {
    static void pass(String naam) {

        naam = "Iron man"; // not changing the obj, but creating a new one
    }

    static void change_arr(int[] newArr) {
        newArr[0] = 99; // Not creating obj, editing original one
    }

    public static void main(String[] args) {
        String name = "Captain";
        pass(name); // passing a copy (original unchanged)
//        In java there is only pass by value for primitives. Not pass by reference. Hence, when we do naam = iron man, it creates a new obj Iron man having ref var naam. Hence, the original ref var remained unchanged.
        System.out.println(name);

//        For non-primitives, the value does changes
        int[] arr = {1 ,2, 3, 4};
        change_arr(arr);
        System.out.println(Arrays.toString(arr));
    }
}
