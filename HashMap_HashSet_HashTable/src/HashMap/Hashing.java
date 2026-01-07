package HashMap;

import java.util.*;

public class Hashing {

    public static void main(String[] args) {

        // country and Population
        HashMap<String, Integer> map = new HashMap<>();

        // insert
        map.put("India", 120);
        map.put("China", 150);
        map.put("USA", 40);

        System.out.println(map);

        map.put("China", 180);
        System.out.println(map);

        // search (lookup)
        if(map.containsKey("China")) {
            System.out.println("Key is present.");
        } else {
            System.out.println("Key is not present.");
        }

        // get value of a key
        System.out.println(map.get("China")); // key exists
        System.out.println(map.get("Wakanda")); // key does not exists

        // diff for loop (foreach) for collections
        int[] arr = {12, 15, 18};
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();

        // in Hashmap, iterate
        for (Map.Entry<String, Integer> elem : map.entrySet()) {
            System.out.print(elem.getKey() + " ");
            System.out.println(elem.getValue());
        }

        // above, we stored complete entries in elem. if we want to store only keys -
        Set<String> keys = map.keySet();
        for(String key : keys) {
            System.out.println(key + " " + map.get(key));
        }

        // remove a entry
        map.remove("China");
    }
}
