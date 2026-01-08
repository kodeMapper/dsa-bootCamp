package Questions;

import java.util.HashMap;
import java.util.HashSet;

public class IntersectionOf2Arrays {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        int[] arr1 = {7,3,9};
        int[] arr2 = {6,3,9,2,9,4};

        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            if(set.contains(arr2[i])) {
                System.out.println(arr2[i]);
                set.remove(arr2[i]);
            }
        }
    }
}
