package com.sarang.singlyLL.leetcode;

public class NthNodeFromEnd {
    static Node head;
    static Node tail;
    static int size;

    public static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static Node getNthNode(Node head, int idxFromEnd) {
        Node temp = head;
        int idxFromStart = size - idxFromEnd + 1;

        for(int i=1; i<=idxFromStart-1; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public static void display() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.val + " --> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void insert(int val) {
        Node node = new Node(val);
        if(head == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public static void main(String[] args) {

        NthNodeFromEnd ll = new NthNodeFromEnd();

        ll.insert(10);
        ll.insert(20);
        ll.insert(30);
        ll.insert(40);
        ll.insert(50);
        ll.insert(60);

        display();

        System.out.println(getNthNode(head, 4).val);
    }
}
