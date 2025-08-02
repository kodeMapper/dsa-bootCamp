package com.sarang;

public class Scoping {
    public static void main(String[] args) {
        int a = 10; // initializing
        something();

        {
            // values are initialized in this block are valid for this block only
            int c = 69;
//            int a = 20;   Already initialized outside the block in the same method, hence we cannot reinitialize it again. But you can change the value like a = 20 and this will be valid for entire method.
        }
//        System.out.println(c);    We can't access the element of block from outside


//        Scoping for "for" loop
        for (int i = 0; i < 5 ; i++) {
            System.out.println(i);
        }
//        System.out.println(i);    Cannot access outside the loop
    }

    static void something() {
//        System.out.println(a);    This method can't access the value defined in other method. This is called as function scope.
    }
}
