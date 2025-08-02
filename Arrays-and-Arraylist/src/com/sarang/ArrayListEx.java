package com.sarang;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList <Integer> list = new ArrayList<>();
//        add elements
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        System.out.println(list);

//        checking the element is there in list or not:
        System.out.println(list.contains(40));

//        modify a element:
        list.set(0, 15);
        System.out.println(list);

//        removing element:
        list.remove(3);
        System.out.println(list);

//        input from user:
        for (int i = 0; i < 5; i++) {
            list.add(sc.nextInt());
        }
        System.out.println(list);

//        accessing specific element with its index:
        System.out.println(list.get(2));
    }
}
