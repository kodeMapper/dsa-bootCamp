package slidingWindow.questions;

public class MaxConsecutiveOnes {

    // ---> Longest subarray with at most k zeros

    /*

    Brute Force:

    public int longestOnes(int[] nums, int k) {

        int maxLength=0, length=0, zeros=0;

        for(int i=0; i<nums.length; i++) {
            zeros = 0;
            for(int j=i; j<nums.length; j++) {
                if(nums[j] == 0) zeros++;
                if(zeros <= k) {
                    length = j-i+1;
                    maxLength = Math.max(maxLength, length);
                } else break;
            }
        }

        return maxLength;
    }

     */
}
