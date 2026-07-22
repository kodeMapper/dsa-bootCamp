package com.sarang.doublyLL;

public class Main {

    public static void main(String[] args) {
        DLL_custom dll = new DLL_custom();

        dll.insertAtFront(10);
        dll.insertAtFront(20);
        dll.insertAtFront(30);
        dll.insertAtFront(40);
        dll.insertAtFront(50);

//        dll.display();
//        dll.displayRev();

//        dll.insertAtEnd(69);
//        dll.display();

        dll.insertAfter(18, 221);
        dll.display();
    }
}
