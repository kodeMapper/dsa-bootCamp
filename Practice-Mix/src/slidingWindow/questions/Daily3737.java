package slidingWindow.questions;
import java.util.HashMap;

public class Daily3737 {
    public static int countMajoritySubarrays(int[] nums, int target) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int j = i; j < nums.length; j++) {
                if (!map.containsKey(nums[j])) {
                    map.put(nums[j], 1);
                } else {
                    map.put(nums[j], map.get(nums[j]) + 1);
                }

                if (map.containsKey(target)) {
                    if (map.get(target) > nums.length) {
                        count++;
                        for(int k=i; k<=j; k++) {
                            System.out.print(nums[k] + " ");
                        }
                    }
                }
            }
        }

        return count;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,2,3};
        int target = 2;

        System.out.println(countMajoritySubarrays(nums, target));
    }
}
