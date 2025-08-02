package com.leetcode;

//https://leetcode.com/problems/richest-customer-wealth/

class MaxWealth {
    static int wealth = 0;
    static int maximumWealth(int[][] accounts) {
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum = sum + accounts[i][j];
            }
            if (wealth < sum) {
                wealth = sum;
            }
        }
        return wealth;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,29,30},
                {4,50,12},
                {49,26,0}
        };
        System.out.println(maximumWealth(arr));
    }
}
