package com.sarang;

public class Main {

    public static void main(String[] args) {
        LL_custom ll = new LL_custom();

//        ll.insertAtFirst(10);
//        ll.insertAtFirst(20);
//        ll.insertAtFirst(30);
//        ll.insertAtFirst(40);
//        ll.displayLL();

        ll.insertAtLast(10);
        ll.insertAtLast(20);
        ll.insertAtLast(30);
        ll.insertAtLast(40);

        ll.insertAtMiddle(69, 2);
        ll.displayLL();

        int deleted = ll.deleteMiddleAndReturn(2);
        System.out.println(deleted + " removed!");
        ll.displayLL();
    }
}
