package slidingWindow;

public class bruteForce {

    static int func(int[] arr, int k) {
        int maxL = 0;

        for(int i=0; i<arr.length; i++) {
            int sum = 0;
            for(int j=i; j<arr.length; j++) {
                sum = sum + arr[j];
                if(sum <= k) {
                    maxL = Math.max(maxL, j-i+1);
                } else break;
            }
        }

        return maxL;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 7, 10};
        int k = 14;
        System.out.println("Maximum Length of subarray where sum <= k : " + func(arr, k));
    }
}