package com.leetcode;

public class CountSteps {

    public static void main(String[] args) {
        System.out.println(countSteps(14));
    }

    static int steps = 0;

    static int countSteps(int num) {
        if(num == 0) {
            return steps;
        }

        if(num % 2 == 0) {
            num = num/2;
        } else {
            num -= 1;
        }

        steps += 1;
        return countSteps(num);
    }
}
