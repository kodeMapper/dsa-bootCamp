package com.sarang.doublyLL;

public class DLL_custom {

    private Node head;
    Node tail;
    int size;

    private class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    public void insertAtFront(int val) {
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;

        size++;
    }

    public void insertAtEnd(int val) {
        if(head == null) {
            insertAtFront(val);
        }
        else {
            if (tail == null) {
                Node node = new Node(val);
                Node temp = head;
                while(temp.next != null) {
                    temp = temp.next;
                }

                temp.next = node;
                node.next = null;
                node.prev = temp;
            }

            if(tail != null) {
                Node node = new Node(val);
                tail.next = node;
                node.next = null;
                node.prev = tail;
            }
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " --> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void displayRev() {
        Node tempLast = null;
        Node tempStart = head;
        while (tempStart != null) { // this loop is for reaching to the last node, then we will print backwards
            tempLast = tempStart; // this is new
            tempStart = tempStart.next;
        }
        while (tempLast != null) { // this loop iterates from end (tempLast) until it gets null of start
            System.out.print(tempLast.val + " --> ");
            tempLast = tempLast.prev;
        }
        System.out.println("START");
    }
}
