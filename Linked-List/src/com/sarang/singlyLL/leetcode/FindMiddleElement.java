package com.sarang.singlyLL.leetcode;

public class FindMiddleElement {

    static Node head;
    static Node tail;
    static int size=0;

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
    
    public static Node middleNode(Node head) {
        Node temp = head;

        while(temp != null) {
            size++;
            temp = temp.next;
        }

        int mid = size/2; // zero-indexed
        temp = head;

        for(int i=0; i<mid; i++) {
            temp = temp.next;
        }

        return temp;
    }

    // USING SLOW AND FAST POINTER
    public static Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(35);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        System.out.println(findMiddle(a).val);
    }
}
