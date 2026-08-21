package com.sarang.questions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseKElements {
    static void reverseQ(Queue<Integer> q, int k) {
        Stack<Integer> st = new Stack<>();

        // put the k elements in the stack (stored in reverse order)
        for(int i=1; i<=k; i++) {
            st.push(q.remove());
        }

        // create temp queue to store the remaining elem of q
        Queue<Integer> temp = new LinkedList<>();
        while(!q.isEmpty()) {
            temp.add(q.remove());
        }

        // pop the k elements from the stack and put in q (k elements reversed)
        for (int i = 1; i <=k; i++) {
            q.add(st.pop());
        }

        // put back the remaining elements from temp to q
        for(int i=1; i<=temp.size()+k; i++) {
            q.add(temp.remove());
        }
    }

    static void main() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);

        System.out.println(q);
        int k = 3;

        reverseQ(q, k);

        System.out.println(q);
    }
}
