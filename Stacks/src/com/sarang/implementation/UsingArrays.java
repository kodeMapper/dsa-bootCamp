package com.sarang.implementation;

public class UsingArrays {

    // 1. Stack Implementation using Arrays
    public static class Stack {
        private int[] arr = new int[5]; // Initialize array with some capacity
        private int idx = 0; // Keeps track of the next empty index

        // Push operation
        void push(int x) {
            if (isFull()) {
                System.out.println("Stack is full!");
                return;
            }
            arr[idx] = x;
            idx++;
        }

        // Peek operation
        int peek() {
            if (isEmpty()) {
                System.out.println("Stack is Empty!");
                return -1;
            }
            return arr[idx - 1]; // Return the topmost element
        }

        // Pop operation
        int pop() {
            if (isEmpty()) {
                System.out.println("Stack is Empty!");
                return -1;
            }
            int top = arr[idx - 1];
            arr[idx - 1] = 0; // Optional: clearing the value
            idx--;
            return top;
        }

        // Display elements of stack
        void display() {
            for (int i = 0; i <= idx - 1; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        // Return the size of the stack
        int size() {
            return idx;
        }

        // Check if the stack is empty
        boolean isEmpty() {
            if (idx == 0) return true;
            return false;
        }

        // Check if the stack is full
        boolean isFull() {
            if (idx == arr.length) return true;
            return false;
        }

        // Return the total capacity
        int capacity() {
            return arr.length;
        }
    }
}


