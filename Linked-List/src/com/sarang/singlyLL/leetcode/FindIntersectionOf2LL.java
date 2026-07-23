package com.sarang.singlyLL.leetcode;

public class FindIntersectionOf2LL {
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

    static void deleteNthNode(int idxFromEnd) {
        Node fast = head;
        Node slow = head;

        for(int i=1; i<=idxFromEnd; i++) {
            fast = fast.next;
        }

        // but we might get exception for n=size
        if(fast == null) {
            head = head.next; // removed head (i.e, last from end)
            return;
        }

        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
    }

    static Node usingSlowFast(Node head, int idxFromEnd) {
        Node fast = head;
        Node slow = head;

        for(int i=1; i<=idxFromEnd; i++) {
            fast = fast.next;
        }

        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void display() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.val + " --> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public static void displayWithHead(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.val + " --> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public static Node intersectingNode(Node head1, Node head2, int size1, int size2) {
        Node slow1 = head1;
        Node slow2 = head2;
        
        int diff = Math.abs(size1 - size2);
        boolean firstIsBig = false;
        firstIsBig = (size1 >= size2);

        Node fast = null;

        if(firstIsBig) {
            fast = slow1;
            for(int i=0; i<diff; i++) {
                if (fast == null) return null;
                fast = fast.next;
            }
            slow1 = fast;
        } else {
            fast = slow2;
            for(int i=0; i<diff; i++) {
                if (fast == null) return null;
                fast = fast.next;
            }
            slow2 = fast;
        }
        
        for(int i=1; i<=diff; i++) {
            fast = fast.next;
        }

        while(slow1 != slow2) {
            slow1 = slow1.next;
            slow2 = slow2.next;
        }

        return slow1;
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

    public static int sizeWithHead(Node head) {
        Node temp = head;
        int count = 0;

        while(temp != null) {
            temp = temp.next;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        FindIntersectionOf2LL ll = new FindIntersectionOf2LL();
        Node a = new Node(100);
        Node b = new Node(13);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(12);
        Node f = new Node(10);
        Node g = new Node(90);
        Node h = new Node(9);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        g.next = h;
        h.next = d;

        displayWithHead(a);
        displayWithHead(g);

        int size1 = sizeWithHead(a);
        int size2 = sizeWithHead(g);

        System.out.println(intersectingNode(a, g, size1, size2).val);
    }
}
