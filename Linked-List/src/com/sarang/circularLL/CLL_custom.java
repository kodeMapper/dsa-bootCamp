package com.sarang.circularLL;

public class CLL_custom {
    private Node head;
    private Node tail;
    private int size;

    public CLL_custom() {
        this.head = null;
        this.tail = null;
    }

    public void insert(int val) {
        Node node = new Node(val);

        if(head == null) {
            head = node;
            tail = node;
            node.next = head;
            return;
        }

        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void delete(int val) {
        Node node = head;
        if(node == null) {
            return;
        }

        // if head is to be removed
        if(node.val == val) {
            head = head.next;
            tail.next = head;
            return;
        }

        do {
            Node nxt = node.next;
            if(nxt.val == val) {
                node.next = nxt.next;
                break;
            }
            node = node.next;
        } while (node != head);
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        if(head != null) {
            do {
                System.out.print(temp.val + " -- > ");
                temp = temp.next;
            } while(temp != head);

            System.out.println("END");
        }
    }

    private class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
