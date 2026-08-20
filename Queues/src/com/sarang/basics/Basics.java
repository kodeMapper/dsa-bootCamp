package com.sarang.basics;

import java.util.LinkedList;
import java.util.Queue;

public class Basics {
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
    }
}
