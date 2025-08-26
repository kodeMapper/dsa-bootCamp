package com.sarang;

import java.util.ArrayList;

public class Operators {
    public static void main(String[] args) {
        System.out.println('a' + 'b'); // 195 (ASCII)
        System.out.println("a" + "b"); // ab (concatenate)
        System.out.println('a' + 3); // a(97) + 3 = 100 hence (char)('a'+3) = d

        // conclusion for above: char will treated as ASCII value, String will concatenate

        System.out.println("a" + 1); // a1 --> integer will converted to Integer (wrapper class) that will call toString()

        System.out.println("a " + new ArrayList<>()); // a []
//        System.out.println(new ArrayList<>() + 5); // error (any one should be String)
        System.out.println(new ArrayList<>() + " " + 5); // this will work
    }
}
