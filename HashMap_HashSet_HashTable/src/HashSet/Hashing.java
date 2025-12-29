package HashSet;

import java.util.HashSet;
import java.util.Iterator; // for iteration of set

public class Hashing {
    public static void main(String[] args) {
        // creating
        HashSet<Integer> set = new HashSet<>();

        // insert
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);

        System.out.println("Size of set is: " + set.size());

        // search - contains
        if(set.contains(2)) {
            System.out.println("Set Contains 2");
        }

        // delete
        set.remove(1);

        if(!set.contains(1)) {
            System.out.println("Does not contain 1 - (deleted)");
        }

        // print all elements
        System.out.println(set);

        set.add(5);
        set.add(132);
        set.add(23);

        // Iterator - for traversing through Hashset
        Iterator itr = set.iterator();

        // 2 imp functions - hasNext(), next
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
