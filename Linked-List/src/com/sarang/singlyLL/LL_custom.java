package com.sarang.singlyLL;

public class LL_custom {

    private Node head;
    private Node tail;
    private int size;

    public LL_custom() {
        this.size = 0;
    }

    // INSERT AT START
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

    // INSERT AT END
    public void insertAtLast(int val) {
        if(tail == null) {
            insertAtFirst(val); // only run for the first element
        } else {
            Node node = new Node(val);
            tail.next = node;
            tail = node;
            size++;
        }
    }

    // INSERT AT SOMEWHERE MIDDLE
    public void insertAtMiddle(int val, int index) {
        if(index == 0) {
            insertAtFirst(val);
            return;
        }

        if(index == size) {
            insertAtLast(val);
            return;
        }

        Node temp = head;

        // this (temp) will stop before the index
        for(int i=1; i<index; i++) {
            temp = temp.next;
        }

        Node node = new Node(val, temp.next);
        temp.next = node;

        size++;
    }

    // DELETE FROM START
    public int deleteFirstAndReturn() {
        int val = head.value; // this will be deleted
        head = head.next;

        if(head == null) {
            tail = null;
        }

        size--;
        return val;
    }

    // DELETE FROM LAST
    public int deleteLastAndReturn() {
        if (size <= 1) {
            return deleteFirstAndReturn();
        }

        Node secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }
    // this gets the second last node
    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    // DELETE MIDDLE ELEMENT
    public int deleteMiddleAndReturn(int index) {
        if (index == 0) {
            return deleteFirstAndReturn();
        }
        if (index == size - 1) {
            return deleteFirstAndReturn();
        }

        Node prev = get(index - 1);
        int val = prev.next.value;

        prev.next = prev.next.next;
        size--;
        return val;
    }

    // RETURN NODE WHOSE VALUE IS
    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
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


