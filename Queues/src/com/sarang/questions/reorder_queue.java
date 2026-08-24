package com.sarang.questions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class reorder_queue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        System.out.println(q);

        Stack<Integer> st = new Stack<>();
        int n = q.size();

        // Step 1: First half to stack
        for (int i = 1; i <= n / 2; i++) {
            st.push(q.remove());
        }
        // q = 5 6 7 8
        // st = 4 3 2 1

        // Step 2: Empty stack to q
        while (st.size() > 0) {
            q.add(st.pop());
        }
        // q = 5 6 7 8 4 3 2 1

        // Step 3: First half to stack
        for (int i = 1; i <= n / 2; i++) {
            st.push(q.remove());
        }
        // q = 4 3 2 1
        // st = 8 7 6 5

        // Step 4: one by one pehle stack se fir queue se
        for (int i = 1; i <= n / 2; i++) {
            q.add(st.pop());
            q.add(q.remove());
        }
        // q = 8 4 7 3 6 2 5 1

        // Step 5: Reverse the queue using stack only
        while (q.size() > 0) {
            st.push(q.remove());
        }
        while (st.size() > 0) {
            q.add(st.pop());
        }

        System.out.println(q);
    }
}
