package com.sarang.doublyLL;

import com.sarang.singlyLL.LL_custom;

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

    // RETURN NODE WHOSE VALUE IS
    public Node find(int value) {
        DLL_custom.Node node = head;
        while (node != null) {
            if (node.val == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    // INSERT val after node
    public void insertAfter(int val, int afterWhat) {
        Node p = find(afterWhat);
        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if(node.next != null) {
            node.next.prev = node;
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
