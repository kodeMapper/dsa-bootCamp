package com.sarang;

public class Palindrome {

    static boolean check(String str) {
        if(str == null || str.length() == 0) {
            return true;
        }

        str = str.toLowerCase();
        char[] arr = str.toCharArray();
        int start = 0;
        int end = arr.length-1;

        while(start <= end) {
            if(arr[start] == arr[end]) {
                start++;
                end--;
            }
            else return false;
        }
        return true;
    }

    /*

    static boolean isPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        str = str.toLowerCase();
        for (int i = 0; i <= str.length() / 2; i++) {
            char start = str.charAt(i);
            char end = str.charAt(str.length() - 1 - i);

            if (start != end) {
                return false;
            }
        }
        return true;
    }

     */

    public static void main(String[] args) {
        String str = "abcdedcba";
        System.out.println("The string is a Palindrome: " + check(str));
    }
}
