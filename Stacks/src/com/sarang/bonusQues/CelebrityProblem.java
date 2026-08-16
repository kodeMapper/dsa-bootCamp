package com.sarang.bonusQues;

import java.util.Stack;

public class CelebrityProblem {
    // M is the boolean matrix where M[i][j] = 1 means i knows j
    public static int celebrity(int M[][], int n) {
        Stack<Integer> st = new Stack<>();

        // Step 1: Push all candidates onto the stack
        for (int i = 0; i < n; i++) {
            st.push(i);
        }

        // Step 2: Eliminate candidates
        while (st.size() > 1) {
            int v1 = st.pop();
            int v2 = st.pop();

            if (M[v1][v2] == 1) {
                // v1 knows v2, so v1 cannot be a celebrity.
                // v2 might be, so push v2 back.
                st.push(v2);
            } else {
                // v1 doesn't know v2, so v2 cannot be a celebrity.
                // v1 might be, so push v1 back.
                st.push(v1);
            }
        }

        if (st.size() == 0) return -1;

        // Step 3: Verify the single potential candidate left
        int potential = st.pop();
        for (int i = 0; i < n; i++) {
            if (i == potential) continue; // don't check against themselves

            // If the potential knows someone, or someone doesn't know the potential
            if (M[potential][i] == 1 || M[i][potential] == 0) {
                return -1;
            }
        }

        return potential;
    }
}