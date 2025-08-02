package com.sarang;

import java.util.Scanner;

public class StringLinearSearch {

    static boolean check(String str, char target) {
        if (str.length() == 0) {
            return false;
        }

//        using simple for loop
        for (int i = 0; i < str.length(); i++) {
            if (target == str.charAt(i)) {
                return true;
            }
        }

//        using for each
        for(char ch: str.toCharArray()) {
            if (ch == target) {
                return true;
            }
        }
        return false;
    }

    static void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String str = sc.nextLine();
        System.out.print("Which char to be search: ");
        char target = sc.next().charAt(0);
        display(check(str, target));
    }

    static void display(boolean result) {
        System.out.println(result);
    }

    public static void main(String[] args) {
        input();
    }
}