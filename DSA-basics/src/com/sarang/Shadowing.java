package com.sarang;

public class Shadowing {
    static int x = 90; // inside a class, not method. This x will be shadowed at line 8 (lower level is overriding the upper level)

    static void call() {
        System.out.println(x); // 90
    }

    public static void main(String[] args) {
        System.out.println(x); // 90
        int x = 40; // declared x a. Worked here becoz the scopes are overlapping. The class var at line 4 is shadowed (override) by this.

/*       Scope will begin only when the var is initialized (given some value)
        int x;
        System.out.println(x);  --> error
        x = 40;
        This won't work
*/
        System.out.println(x); // 40
        call();
    }
}
