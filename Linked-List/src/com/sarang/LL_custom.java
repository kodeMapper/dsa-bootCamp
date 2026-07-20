package com.sarang;

public class LL_custom {

    private Node head;
    private Node tail;
    private int size;

    public LL_custom() {
        this.size = 0;
    }

    // INSERT
    public void insertAtFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        // it means if it's first the item
        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    // DISPLAY
    public void displayLL() {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.value + " --> ");
            temp = temp.next;
        }

        System.out.println("END");
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value; // when no (next) node provided, the node will be null
        }

        // but if provided,
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}


