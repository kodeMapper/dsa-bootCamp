package com.sarang;

public class NumbersExample_Recursion {

    public static void main(String[] args) {
        print(1);
    }

    static void print(int n) {
        if (n==5) {    // Base condition (condition where, our recursion will stop making new calls)
            System.out.println(5);
            return;
        }
        System.out.println(n);

        // This is called tail recursion
        // This is the last function call
        print(n+1);
    }

    /*
        Even though there is only one function, still it will consume stack memory space each time when it will get called. So if there is no base condition, it will get called again and again, till the stack memory limit exceeds --> "Stack overflow error"
     */
}

