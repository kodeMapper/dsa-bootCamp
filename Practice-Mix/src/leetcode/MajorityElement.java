package leetcode;
import java.util.HashMap;
import java.util.*;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        HashMap <Integer, Integer> map = new HashMap<>();
        int max=0;
        int maxKey=0;

        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        for(
                Map.Entry <Integer, Integer> elem : map.entrySet()
        ) {

            max = Math.max(max, elem.getValue());
            maxKey = elem.getKey();

            if(max > nums.length/2) {
                return maxKey;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(majorityElement(nums));
    }
}


