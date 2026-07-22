package com.sarang.circularLL;

public class Main {

    public static void main(String[] args) {
        CLL_custom cll = new CLL_custom();

        cll.insert(10);
        cll.insert(20);
        cll.insert(30);
        cll.insert(40);
        cll.insert(50);
        cll.insert(60);

//        cll.display();

        cll.delete(40);
        cll.display();
    }
}
