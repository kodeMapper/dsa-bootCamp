package com.sarang;

import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fruit = sc.next();

/*        == compares the values along with their reference. For ex, if a points to "mango" and b points to         other "mango" then == will give false. Hence we use .equal() method
        if (fruit == "mango") {

        }
        if(fruit.equals("mango")) {

        }



        switch (fruit) {
            case "mango":
                System.out.println("King of fruit");
                break;
            case "apple":
                System.out.println("Keeps Doc away");
                break;
            default:
                System.out.println("Other");
        }
 */
//        enhanced syntax: alt+enter

        switch (fruit) {
            case "mango" -> System.out.println("King of fruit");
            case "apple" -> System.out.println("Keeps Doc away");
            default -> System.out.println("Other");
        }
    }
}
