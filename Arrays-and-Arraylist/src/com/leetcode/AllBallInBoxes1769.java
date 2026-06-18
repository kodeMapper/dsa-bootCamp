package com.leetcode;

import java.util.Arrays;

public class AllBallInBoxes1769 {
    public int[] minOperations(String boxes) {

        int[] ans = new int[boxes.length()];
        int n = boxes.length();

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                if (boxes.charAt(j) == 0)
                    continue;
                else {
                    count += Math.abs(j - i);
                }
            }

            if (i > 0) {
                for (int j = 0; j < i; j++) {
                    if (boxes.charAt(j) == 0)
                        continue;
                    else {
                        count += Math.abs(j - i);
                    }
                }
            }

            ans[i] = count;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new AllBallInBoxes1769().minOperations("110")));
    }
}
