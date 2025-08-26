package com.sarang;

// String Comparison
public class CompareStrings {

    public static void main(String[] args) {
        String a = "Sarang";
        String b = "Sarang";
        String c = a;

        // here, both var pointing to the same obj
        System.out.println(a == b);  // true
        // or
        System.out.println(b == c); // true

        // create diff objects with same value (avoiding the pool's function)
        String name1 = new String("Sarang");
        String name2 = new String("Sarang");
        System.out.println(name1 == name2); // false

        // check only value
        System.out.println(name1.equals(name2)); // true

        // Accessing character in a String using index
        System.out.println(name1.charAt(0));
    }
}
