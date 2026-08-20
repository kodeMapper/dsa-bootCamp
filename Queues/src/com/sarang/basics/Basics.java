package com.sarang.basics;

import java.util.LinkedList;
import java.util.Queue;

public class Basics {
    static void display(Queue<Integer> q) {
        Queue<Integer> temp = new LinkedList<>();
        while(q.peek() != null) {
            int val = q.poll();
            System.out.print(val + " ");
            temp.add(val);
        }
        System.out.println();
        while(temp.peek() != null) {
            int val = temp.poll();
            q.add(val);
        }
    }
    static void main() {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);

        System.out.println(q);
        int ans = q.element(); // try remove, poll, peek, element
        System.out.println(q);
        System.out.println("ans: " + ans);

        display(q);
        System.out.println(q);
    }
}
