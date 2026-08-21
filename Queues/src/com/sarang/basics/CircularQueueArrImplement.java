package com.sarang.basics;

public class CircularQueueArrImplement {

    public static class CQA {
        int front = -1;
        int rear = -1;
        int size = 0;
        int[] arr = new int[8]; // Taking an array of initial capacity 8

        // Add element to the circular queue
        public void add(int val) throws Exception {
            if (size == arr.length) {
                // If the queue size reaches array length, throw an error
                throw new Exception("Queue is full");
            }
            else if (size == 0) {
                // Base case: if queue is empty, set front and rear to 0
                front = rear = 0;
                arr[0] = val;
            }
            else if (rear < arr.length - 1) {
                // Normal case: if rear is not at the last index, increment rear and add
                arr[++rear] = val;
            }
            else if (rear == arr.length - 1) {
                // Circular behavior: if rear reaches end but queue isn't full, loop back to 0
                rear = 0;
                arr[0] = val;
            }
            size++; // Increase the size tracker
        }

        // Remove element from the circular queue
        public int remove() throws Exception {
            if (size == 0) {
                throw new Exception("Queue is empty");
            }
            else {
                int val = arr[front]; // Store the value before moving front
                if (front == arr.length - 1) {
                    // Circular behavior: if front reaches end, loop back to 0
                    front = 0;
                } else {
                    // Normal case: front moves ahead
                    front++;
                }
                size--; // Decrease the size tracker
                return val;
            }
        }

        // View the front element
        public int peek() throws Exception {
            if (size == 0) {
                throw new Exception("Queue is empty");
            } else {
                return arr[front];
            }
        }

        // Check if the circular queue is empty
        public boolean isEmpty() {
            if (size == 0) {
                return true;
            } else {
                return false;
            }
        }

        // Display the circular queue elements
        public void display() {
            if (size == 0) {
                System.out.println("Queue is empty");
            }
            else if (front <= rear) {
                // Normal printing if front is behind rear
                for (int i = front; i <= rear; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
            else {
                // Circular printing if rear has looped behind front
                for (int i = front; i < arr.length; i++) {
                    System.out.print(arr[i] + " ");
                }
                for (int i = 0; i <= rear; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        CQA q = new CQA();
        q.display();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.display(); // Output: 1 2 3 4

        q.remove();
        q.display(); // Output: 2 3 4

        q.add(5);
        q.add(6);
        q.display(); // Output: 2 3 4 5 6
    }
}