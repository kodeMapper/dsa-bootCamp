package com.sarang.basics;

public class LL_implementation {

    // User defined data type
    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    // User defined data structure
    public static class queueLL {
        Node head = null;
        Node tail = null;
        int size = 0;

        // Add element from the tail
        public void add(int x) {
            Node temp = new Node(x);
            if (size == 0) { // If the list is empty
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp; // move the tail forward
            }
            size++;
        }

        // Remove element from the head
        public int remove() {
            if (size == 0) {
                System.out.println("Queue is empty");
                return -1;
            }
            int x = head.val;
            head = head.next; // move head pointer to the next node
            size--;
            return x;
        }

        // View the head element
        public int peek() {
            if (size == 0) {
                System.out.println("Queue is empty");
                return -1;
            }
            return head.val;
        }

        // Display the queue
        public void display() {
            if (size == 0) {
                System.out.println("Queue is empty");
                return;
            }
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        // Check if the queue is empty
        public boolean isEmpty() {
            if (size == 0) return true;
            else return false;
        }
    }

    public static void main(String[] args) {
        queueLL q1 = new queueLL();
        q1.display();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(4);
        q1.display();
        System.out.println(q1.peek());
        q1.remove();
        q1.display();
    }
}