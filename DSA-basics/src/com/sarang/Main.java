package com.sarang;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        System.out.println("Enter a number:");
        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        System.out.println(num);

//      Identifier and literal:
//      In primitive data types, a is identifier(ref variable, method/package/class) and 10 is literal (Syntactical representations of data type) for
//        int a = 10;

//        If we want to print some big number like 23,50,000
        int price = 23_50_000;
        System.out.println(price);
//        _ gets ignored.

//        Typecasting
/*        float a = sc.nextInt();
       System.out.println(a);

        int a = (int)(67.156f);
        System.out.println(a);

       automatic type promotion in expressions
       int a = 257;         limit for a byte var is 256
       byte b = (byte)(a);  tried to store the int (257) in byte var
       sout(b);
       This gives 1 --> 257 % 256 = 1

        byte a = 40;
        byte b = 50;
        byte c = 100;
        int d = a * b / c;  here, a, b and c are bytes. but java automatically promotes these var into int while calculating this expression

        Rules :
        1. All the byte, short and Char values are promoted to Integer.
        2. If any one of the operands is long, the whole operation will convert to long. Same for double and float.
        System.out.println(d);

        other example is ASCII conversions
        int num = 'A';
        sout(num);
        This will give 65
 */
//        Java follows UniCode principles (support all languages)
        System.out.println("नमस्कार मंडळी");

        byte b = 42;
        char c = 'a';
        short s = 1024;
        int i = 50000;
        float f = 5.67f;
        double d = 0.1234;
        double result = (f * b) + (i / c) - (d * s);
//        result = (float * byte promoted in float) + (int / char promoted in int) - (double * short promoted in double) --> float + int + double = double
        System.out.println((f * b) + " " + (i / c) + " " + (d * s));
        System.out.println(result);

        int count = 1;
        while(count != 5) {
            System.out.println("नमस्कार मंडळी");
             count++;
        }

/*      When to use while and when to use for?
        If you know how many times you have to run the loop then use for loop. ex, print numbers upto 100.
        And if you don't know how many times you have to run the loop then use while loop. ex, print Hello till user presses 'x'
*/
//        Finding largest number using Math class
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        int max = Math.max(Math.max(num1, num2), num3);
        System.out.println(max);
    }
}