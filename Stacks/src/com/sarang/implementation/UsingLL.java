package com.sarang.implementation;

public class UsingLL {

    // 2. Stack Implementation using Linked Lists
    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static class LLStack {
        private Node head = null;
        private int size = 0;

        // Push element onto the stack
        void push(int x) {
            Node temp = new Node(x);
            temp.next = head; // Point new node to the current head
            head = temp;      // Update head to the new node
            size++;
        }

        // Remove and return top element
        int pop() {
            if (head == null) {
                System.out.println("Stack is Empty!");
                return -1;
            }
            int x = head.val;
            head = head.next; // Move head to the next node
            size--;
            return x;
        }

        // Return top element
        int peek() {
            if (head == null) {
                System.out.println("Stack is Empty!");
                return -1;
            }
            return head.val;
        }

        // Helper method to display elements correctly (bottom to top)
        void displayRec(Node h) {
            if (h == null) return;
            displayRec(h.next);
            System.out.print(h.val + " ");
        }

        // Display elements of stack
        void display() {
            displayRec(head);
            System.out.println();
        }

        // Display elements top to bottom
        void displayRev() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        // Return current size of the stack
        int size() {
            return size;
        }

        // Check if stack is empty
        boolean isEmpty() {
            if (size == 0) return true;
            return false;
        }
    }
}
