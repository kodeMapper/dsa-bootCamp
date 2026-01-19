package com.easy_questions;

public class CountZeros {

    public static void main(String[] args) {
        System.out.println(countZero(30402, 0));
    }

    static int countZero(int n, int count) {
        if(n == 0) {
            return count;
        }
    
        int rem = n % 10;
        if(rem == 0) {
            count++;
        }

        return countZero(n/10, count);
    }
}
