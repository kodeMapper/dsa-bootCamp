package com.sarang;

import java.util.Arrays;

public class Methods {
    public static void main(String[] args) {
        String name = "Sarang Gade";

        System.out.println(Arrays.toString(name.toCharArray())); // convert in character array
        System.out.println(name.toLowerCase()); // convert in lower case
        System.out.println(name.indexOf('G')); // index of a char in the String
        System.out.println("    Sarang ".strip()); // remove spaces of start and end
        System.out.println(Arrays.toString(name.split(" "))); // split at regex to form an array

    }
}
