package leetcode;

public class LongestBitwiseXor {
    public static int longestSubsequence(int[] nums) {
        int n = nums.length;
        int len = 0;

        for (int i = 0; i < n-1; i++) {
            int count = 0;
            int xor = nums[i];
            for (int j = i; j < n-1; j++) {
                xor = xor ^ nums[j+1];
                if (xor == 0) {
                    len = j-i+1;
                    break;
                }
                count++;
            }

            len = Math.max(len, count+1);
        }

        return len;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4};
        System.out.println(longestSubsequence(nums));
    }
}
