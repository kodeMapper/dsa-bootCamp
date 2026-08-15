package leetcode;

public class LongestBitwiseXor {
    public static int longestSubsequence(int[] nums) {
        int xor = 0;
        for (int x : nums) xor ^= x;
        if (xor != 0) return nums.length;

        boolean allZero = true;
        for (int x : nums) {
            if (x != 0) {
                allZero = false;
                break;
            }
        }
        if (allZero) return 0;
        return nums.length == 1 ? 0 : nums.length - 1;
    }

    public static void main(String[] args) {
        int[] nums = {7, 6, 1, 9};
        System.out.println(longestSubsequence(nums));
    }
}