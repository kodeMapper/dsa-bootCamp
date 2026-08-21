package com.sarang.basics;

import java.util.*;

public class deque {
    public static void main(String[] args) {

        Deque<Integer> dq = new LinkedList<>();

        // Adding elements to the last (right side)
        dq.addLast(1);
        dq.addLast(2);
        dq.addLast(3);
        dq.addLast(4);
        System.out.println(dq); // Output: [1, 2, 3, 4]

        // Adding element to the first (left side)
        dq.addFirst(5);
        System.out.println(dq); // Output: [5, 1, 2, 3, 4]

        // Removing element from the last
        dq.removeLast();
        System.out.println(dq); // Output: [5, 1, 2, 3]

        // Removing element from the first
        dq.removeFirst();
        System.out.println(dq); // Output: [1, 2, 3]

        // Accessing first and last elements
        System.out.println(dq.getFirst()); // Output: 1
        System.out.println(dq.getLast());  // Output: 3

        // dq.add() behaves like addLast()
        dq.add(6);

        // dq.remove() behaves like removeFirst()
        dq.remove();
        System.out.println(dq); // Output: [2, 3, 6]

        // Removing all elements
        dq.removeAll(dq);
        System.out.println(dq); // Output: []

        // Removing specific occurrences
        dq.add(1);
        dq.add(2);
        dq.add(3);
        dq.add(2);
        dq.add(5);
        System.out.println(dq); // Output: [1, 2, 3, 2, 5]

        dq.removeFirstOccurrence(2);
        System.out.println(dq); // Output: [1, 3, 2, 5]

        dq.removeLastOccurrence(2);
        System.out.println(dq); // Output: [1, 3, 5]
    }
}