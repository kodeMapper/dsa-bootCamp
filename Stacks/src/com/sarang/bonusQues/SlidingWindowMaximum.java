package com.sarang.bonusQues;

import java.util.Stack;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        // Array to store the 'Index' of the Next Greater Element
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        st.push(n - 1);
        nge[n - 1] = n; // Default to 'n' if there is no greater element

        // Step 1: Compute NGE array using a Stack
        for (int i = n - 2; i >= 0; i--) {
            // Pop smaller elements
            while (st.size() > 0 && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            if (st.size() == 0) nge[i] = n;
            else nge[i] = st.peek();

            st.push(i);
        }

        // Step 2: Traverse windows and jump using NGE
        int j = 0;
        for (int i = 0; i < n - k + 1; i++) {
            // j should be at least equal to i (the start of the current window)
            if (j < i) j = i;

            // Jump to the next greater element as long as it's within the window
            while (nge[j] < i + k) {
                j = nge[j];
            }
            // Add the max element of the current window to the answer array
            ans[i] = nums[j];
        }

        return ans;
    }
}