package com.sarang.singlyLL.leetcode;

public class ReverseLL {

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

    public static void displayRev(Node head) {
        Node temp = head;
        if(temp == null) return;
        displayRev(temp.next);
        System.out.print(temp.val + " --> ");
    }

    public static Node reverseList(Node head) {
        if(head.next == null) { // base
            return head;
        }
        Node newHead = reverseList(head.next); //call
        head.next.next = head; // interchanging connections (work)
        head.next = null; // work
        return newHead;
    }

    public static void display(Node head) {
        Node temp = head;
        if(temp == null) return;

        System.out.print(temp.val + " --> ");
        display(temp.next);
    }

    public static void main(String[] args) {
        Node a = new Node(3);
        Node b = new Node(5);
        Node c = new Node(1);
        Node d = new Node(2);
        Node e = new Node(4);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        display(a);
        System.out.println();
        Node newHead = reverseList(a);
        display(newHead);
    }
}
