package com.sarang;

public class PrettyPrinting {
    public static void main(String[] args) {
        double pi = Math.PI;
//      System.out.println(pi);     --> simple print (without a placeholder)

        System.out.printf("Formatted Value is %.3f", pi); // ---> formatted print (Same as C lang)
    }
}
