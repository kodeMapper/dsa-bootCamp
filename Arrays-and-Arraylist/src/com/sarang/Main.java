package com.sarang;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

//    static int input() {
//        Scanner sc = new Scanner(System.in);
//
//    }
    static void displayArr(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
//        int[] arr = new int[5];  Declaration and initialization (obj creation, memory allocation in heap memory)
//        left part happen at compile time and right part happens at run time called as dynamic memory allocation.
//        or
        int[] arr = {1,2,3,4,5}; // Array declared, initialized and defined.
        displayArr(arr);

/*      Default values of arrays
        int -> 0
        String -> null (null is a literal. We cannot assign it as a datatype, but we can define it as a value for a var having datatype string)
*/
/*        Array input from the user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of array: ");
        int size = sc.nextInt();
        int[] intArr = new int[size];
        System.out.print("Enter elements of the Array: ");
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = sc.nextInt();
        }
        System.out.print("\nThe array is: ");
        System.out.println(Arrays.toString(intArr));
*/
/*        for each loop:
        int[] myArr = new int[5];
        for(int e: myArr) {
            System.out.println(e+" "); // here, e represents element of the array. Syntax says that for every element in the array, print the element.
        }
        System.out.println(myArr[5]); ERROR: Array index out of Bound.
*//*

    Notes:
        There is no concept of addresses & pointers in java, hence continuous memory allocation may not be there in java, like C and C++.
        It is totally depend upon JVM.
          Because:
            1. Array/any obj are created in heap. and HEAP OBJECTS ARE MAY NOT CONTINUOUS.
            2. The memory allocation for array happen at run time in Heap memory.
            3. Hence, Array may not be continuous.

*/
    }
}