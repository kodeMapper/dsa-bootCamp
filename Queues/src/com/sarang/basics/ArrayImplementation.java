package com.sarang.basics;

public class ArrayImplementation {
    public static class queueA {
        int f = -1;
        int r = -1;
        int size = 0;
        int[] arr = new int[100]; // taking an array of initial capacity 100

        // Add element to the queue (Push)
        public void add(int val) {
            if (r == arr.length - 1) {
                System.out.println("Queue is full");
                return;
            }
            if (f == -1) { // if the queue is currently empty
                f = r = 0;
                arr[0] = val;
            } else {
                arr[++r] = val; // increment rear and then add the value
            }
            size++;
        }

        // Remove element from the queue (Pop)
        public int remove() {
            if (size == 0) {
                System.out.println("Queue is empty");
                return -1;
            }
            int x = arr[f];
            f++; // front moves ahead by 1 index
            size--;
            return x;
        }

        // View the front element without removing (Top)
        public int peek() {
            if (size == 0) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[f];
        }

        // Check if the queue is empty
        public boolean isEmpty() {
            if (size == 0) {
                return true;
            } else {
                return false;
            }
        }

        // Display the queue elements
        public void display() {
            if (size == 0) {
                System.out.println("Queue is empty");
            } else {
                for (int i = f; i <= r; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        queueA q = new queueA();
        q.display();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.display();
        q.remove();
        q.display();
        System.out.println(q.peek());
    }
}
